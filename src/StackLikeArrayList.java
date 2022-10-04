import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackLikeArrayList {
        public static void main(String[] args) {
            StackBasedOnArrayList<Integer> myStack = new StackBasedOnArrayList<>();
            System.out.println("Call method isEmpty before adding items, result is - "
                    + myStack.isEmpty() +"."); // check size of stack
            myStack.push(5);
            myStack.push(6);
            myStack.push(7);

            System.out.println("Call method isEmpty after adding items, result is - "
                    + myStack.isEmpty() + "."); // check size after adding items
            System.out.println(myStack.size() + " - is a size of stack."); //

            System.out.println(myStack.peek() + " - is returned item from top.");
            System.out.println(myStack.pop() + " - deleted and returned item from stack.");
            System.out.println(myStack.peek() + " - is returned item from top after method pop."); // should be item "6"
            System.out.println( "On position "+ myStack.search(5) + " - lies object in stack.");
        }

        static class StackBasedOnArrayList<E>{
            List<E> list = new ArrayList<>(0);

            public int size(){
                return list.size();
            }

            public E push(E object){
                list.add(object);
                return object;
            }

            public E peek(){
                if(list.isEmpty()){
                    throw  new EmptyStackException();
                }
                return list.get(list.size()-1);
            }

            public E pop(){
                if(list.isEmpty()){
                    throw  new EmptyStackException();
                }
                E e = list.get(list.size()-1);
                list.remove(list.size()-1);
                return e;
            }

            public boolean isEmpty(){
                return list.size() == 0;
            }

            //counting begins from 1
            public int search(E object){
                int i = list.lastIndexOf(object);
                if(i >= 0){
                    return i + 1;
                }
                return -1;  // return -1 if there is no item
            }
        }
    }