public class LListApp {

    public static LLList intersect(LLList list1, LLList list2) {
        LLList inters = new LLList();
        ListIterator iter1 = list1.iterator();
        while (iter1.hasNext()) {
            Object item1 = iter1.next();
            ListIterator iter2 = list2.iterator();
            while (iter2.hasNext()) {
                Object item2 = iter2.next();
                if (item1.equals(item2)) {
                    inters.addItem(item1, inters.length());
                    break; 
                }
            }
        }
        return inters;
    }
    

    public static void main(String[] args) {
        LLList l1 = new LLList(new Integer[] {1,2,3,3,5});
        LLList l2 = new LLList(new Integer[] {8,3,3,7});
        LLList inters = intersect(l1, l2);
        System.out.println(inters);
        System.out.printf("%d ", args);
    }
}
