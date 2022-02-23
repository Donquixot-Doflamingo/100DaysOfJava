public class Node<T> {
    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
        // this isn't required cause the defult value of any reference is null
        // next = null;
    }
}
