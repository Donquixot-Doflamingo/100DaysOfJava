package org.dsa.revamp.common;

import lombok.extern.slf4j.Slf4j;
import org.dsa.revamp.DSAProblemRunner;
import org.dsa.revamp.problems.ProblemTest;

import java.util.List;

@Slf4j
public class DSAProblemScanner {

    /**
     * Find all ProblemTest implementations in the problems package
     */
    @SuppressWarnings("unchecked")
    public static List<ProblemTest<?, ?>> findAllProblems() {
        // Use raw type for the method call, then cast the result
        return (List<ProblemTest<?, ?>>) (List<?>) InterfaceImplementationFinder.findAndInstantiate(
                ProblemTest.class,
                "org.dsa.revamp.problems.impl"
        );
    }

    /**
     * Run all discovered problems
     */
    public static void runAllProblems() {
        List<ProblemTest<?, ?>> problems = findAllProblems();

        if (problems.isEmpty()) {
            log.info("No problem implementations found!");
            return;
        }

        log.info("Found {} problem implementations:", problems.size());

        for (ProblemTest<?, ?> problem : problems) {
            try {
                runProblemTest(problem);
            } catch (Exception e) {
                log.info("Error running {}: {}", problem.getClass().getSimpleName(), e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static <I, O> void runProblemTest(ProblemTest<?, ?> problem) {
        // Cast is safe because we're just passing it through
        DSAProblemRunner.runTests((ProblemTest<I, O>) problem);
    }
}