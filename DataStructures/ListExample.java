package DataStructures;

/**
* @author Srinvas Vadige 
* @since 21 Sept 2014
*/
public class ListExample {

    public static void main(String[] args) {
        
    }
}

/* 
DECLARE & INITIALIZE LIST:
—————————————————
List<String> list1 = List.of(...) => immutable just use it for looping i.e acts as tuples in python
List<String> list2 = new ArrayList<>( List.of(1,2,3) )
List<String> list3 = Arrays.asList(1,2,3)
List<String> list4 = new ArrayList<>( Arrays.asList(1,2,3) )
List<String> list5 = new ArrayList<>(); list5.append()....;
list = Arrays.stream(intArr).boxed().toList()
list = Arrays.stream(integerArr).toList()
Stream.toList() or Stream.collect(toList) are IMMUTABLE. So, use only Stream.collect(Collectors.toList()) for mutable list.
 */









/* 

LIST METHODS
============
import from Java.util.List, ArrayList, LinkedList;
Always define type as List and initialize with ArrayList<>()
.add(ele)
.addAll(list)
.addAll(index, list)
.add(index, ele)
.set(index, ele)
.get(index)
.remove(index) or .remove(ele)
.removeAll(list)
.removeIf( -> )
.indexOf(ele)
. lastIndexOf(ele)
.contains(ele) or .contains(list)
.clear()
.clone()
.size()
.isEmpty()
.equals(list)
.toArray() or toArray(EleDataType[])
.forEach()
.stream()
.parallelStream()
.hashCode()
.iterator()
.listIterator()
.spliterator()
.subList(fromIndex, toIndex)
.replaceAll(UnaryOperator<E> operator)
.retainAll(list)
.sort(Comparator<super E> c)



1) LIST STREAM FILTER
—————————————
ArrayList<String> filteredColors = (ArrayList<String>) colorsLst.stream().filter(x -> x.contains("o")).collect(Collectors.toList());
or filteredColors.removeIf(x -> !x.contains("o"));


2) CLONE
—————
and remove unwanted(TRADITIONAL FILTERING)
filteredColors = (ArrayList<String>) colors.clone();
or filteredColors.removeIf(x -> !x.contains("o"));

3) FIND ELEMENT
—————————-
Find specific element
colors.stream().filter(x -> x.contains("ora")).findFirst().get();

4) IMMUTABLE LISTS:
————————————
Arrays.asList(1, 2); or List.of(1,2) or Collections.unmodifiableList(Arrays.asList(1,2)); or Stream.toList() are immutable lists. 

5) IMMUTABLE TO MUTABLE LIST
——————————————————
So use “new ArrayList<>(Arrays.asList or List.of)” to make them as mutable.
Or
Arrays.stream(int[]).boxed().collect( Collectors.toList()); => to convert to List
Or
Arrays.stream(int[]).boxed().collect( Collectors.toCollection(ArrayList::new) ); => to ArrayList


6) LIST TO ARRAY
—————————-
String[] arr = {"foo", "bar"};
List<String> lst=new ArrayL<>(Arrays.asList(arr));
lst.toArray() => returns Object[] not String[]. 
So, arr = lst.toArray(String[]::new);


7) REMOVE ELE FROM INTEGER LIST
———————————————————-
.remove() method’s param takes Object and as well as index. So, what happens in List<Integer> ???
By default in List<Integer> list.remove(2) will remove the ele at index 2. So in order to remove the 2 from the list use below options:
list.remove(new Integer(2));
list.remove(Integer.valueOf(2));
list.remove((Integer) 2);
list.remove(list.indexOf(2));
list.removeIf(element -> element == 2);
list.removeAll(Arrays.asList(2)); // removes all occurrences of 2

 */



