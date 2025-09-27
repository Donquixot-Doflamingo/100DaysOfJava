package org.dsa.revamp.common;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Modifier;

@Slf4j
public class InterfaceImplementationFinder {

    /**
     * Find all classes implementing a specific interface in a package
     * Note: This only works for classes already loaded by the classloader
     */
    public static <T> List<T> findAndInstantiate(Class<T> interfaceClass, String packageName) {
        List<T> instances = new ArrayList<>();

        try {
            // Get all classes in the package
            List<Class<?>> classes = getClassesInPackage(packageName);

            for (Class<?> clazz : classes) {
                // Check if class implements the interface
                if (interfaceClass.isAssignableFrom(clazz) &&
                        !clazz.isInterface() &&
                        !Modifier.isAbstract(clazz.getModifiers())) {

                    try {
                        // Create instance using no-args constructor
                        T instance = (T) clazz.getDeclaredConstructor().newInstance();
                        instances.add(instance);
                        log.info("✅ Created instance of: {}", clazz.getSimpleName());
                    } catch (Exception e) {
                        log.error("❌ Failed to instantiate: {} - {}", clazz.getSimpleName(), e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            log.error("❌ Error scanning package: {}", e.getMessage());
        }

        return instances;
    }

    /**
     * Get all classes in a package (basic implementation)
     * Note: This is a simplified version that works for file-based classpaths
     */
    private static List<Class<?>> getClassesInPackage(String packageName) throws Exception {
        List<Class<?>> classes = new ArrayList<>();
        String packagePath = packageName.replace('.', '/');

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL packageURL = classLoader.getResource(packagePath);

        if (packageURL == null) {
            throw new RuntimeException("Package not found: " + packageName);
        }

        File packageDir = new File(packageURL.toURI());
        if (packageDir.exists() && packageDir.isDirectory()) {
            scanDirectory(packageDir, packageName, classes);
        }

        return classes;
    }

    /**
     * Recursively scan directory for class files
     */
    private static void scanDirectory(File dir, String packageName, List<Class<?>> classes) {
        File[] files = dir.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                // Recursively scan subdirectories
                scanDirectory(file, packageName + "." + file.getName(), classes);
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + "." + file.getName().replace(".class", "");
                try {
                    Class<?> clazz = Class.forName(className);
                    classes.add(clazz);
                } catch (ClassNotFoundException e) {
                    log.error("⚠️ Could not load class: {}", className);
                }
            }
        }
    }
}
