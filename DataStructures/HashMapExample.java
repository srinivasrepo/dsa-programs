package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// NOTE: In loops (Eg: for counting num of chars in a string) use stream or MERGE or COMPUTE instead of get and put combined

@SuppressWarnings("unused")
public class HashMapExample {

    public static void main(String[] args) {


        // to get the all characters occurances in a string
        String str = "srinivasrepo";
        Map<String, Long> charMap = Arrays.stream(str.split(""))
                                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character, Integer> charMap2 = Arrays.stream(str.split(""))
                                        .collect(Collectors.groupingBy(i-> i.charAt(0), Collectors.summingInt(e -> 1)));
        Map<Character, Integer> charMap3 = str.chars().mapToObj(e->(char)e)
                                        .collect(Collectors.groupingBy(i-> i, Collectors.summingInt(e -> 1)));
        // Function.identity() or i->i ---- both works
        // Collectors.summingInt(e -> 1) will count but Collectors.summingInt(Integer::valueOf) will sum all the items / values but here the item is char.
/* 
        Here we cannot use identity (Function::identity) and counting as method references and get error 
        Because this identity and counting methods don't have expected number of arguments 
        (here expected number of args in classifier.apply(t) is 1 but Function.identity() method has 0 args) 
        (and downstream.supplier() return type is Supplier<A> but Collectors.counting() return type is Collector)
*/
        // str.chars().mapToObj(e->(char)e) --- Stream<Character> and in console it's type of IntPipeline$1
        System.out.println(charMap);
        System.out.println(charMap2);
        System.out.println(charMap3);


        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        // IMP NOTE
        // instead of
        map.put('A', map.get('A')!=null? map.get('A')+1 : 1); 
        // or 
        map.put('A', map.getOrDefault('A', 0) + 1 );
        //use
        map.merge('A', 1, Integer::sum);


        // PUT (add new or update existing)
        map.put('A',1); //=> map.put(k,v) to insert new or update existing
        map.putIfAbsent('A',1); //=> only insert new entry set
        map.putAll(map2); //=> map.putAll(HashMap / TreeMap / any Map obj) to add 2 maps
        
        // GET
        map.get('A'); //=> returns value or null
        map.getOrDefault('B', 0); //=> map.getOrDefault(k, defaultValue); v or defVal

        // REMOVE
        map.remove('B');

        // REPLACE (only update existing)
        map.replace('B', 0);
        map.replaceAll((key, oldValue)-> oldValue++); // BiFunction

        // FIND ITEM
        map.containsKey('Z'); // => boolean
        map.containsValue(99); // => boolean

        // 
        map.isEmpty();
        map.clear();
        map.clone();
        map.size();

        // MERGE    (ALL THESE .MERGE() ARE SAME)
        map.merge('C', 1, Integer::sum); // =>  map.merge(k, v, vdt::sum);
        map.merge('B', 1, (oldVal,newVal)-> oldVal+newVal);
        map.merge('B', 1, (ov,nv)->{ return ov+nv; } );
        map.merge('A', 5, (oldV,newV)-> oldV==null? 1:newV+oldV);

        // COMPUTE
        map.compute('S', (k,v)-> v==null?1:v+1); // map.compute(Keysymbol, (k,v)-> v==null?1:v+1);
        map.computeIfAbsent('S', (v)-> v==null?1:v+1);
        map.computeIfPresent('S', (k,v)-> v==null?1:v+1);


        // TO ITERATE Map.entrySet() & Map.keySet() => In collection or stream Java8 Iterable.forEach() lambda
        // we can only use continue using “return;” but cannot break the look. So, use collection.forEach or stream.forEach or java 5 traditional 'enhanced for loop (for each)' / traditional for loop.
        
        // MAP TO ENTRY SET
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet(); // map.entrySet()=> Set<Map.Entry<kdt,vdt>> entry => entry.getKey() and entry.getValue()
        // FYI: "Set" or "HashSet" don't have .get() method. So, iterate or convert to stream, list or iterator
        entrySet.stream().toList().get(0).getKey();
        entrySet.stream().toList().get(0).getValue();
        map.entrySet().iterator().next().getKey();

        
        // MAP TO KEY SET
        Set<Character> set = map.keySet(); // => Set<kdt> set
        set.stream().toList().get(0); // => key
        
        // MAP TO VALUES COLLECTION
        Collection<Integer> collecOfVals = map.values(); // => Collection<ValDataType>

        // MAP FOREACH
        map.forEach( (k,v) -> System.out.printf("%s%s, ", k, v));



        //  TO GET KEY USING VALUE
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (Objects.equals(99, entry.getValue())) {
                entry.getKey(); // return
            }
        }
        // or
        map.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), 1)).map(Map.Entry::getKey).collect(Collectors.toList()).get(0); // set or list or get


        // LIST TO MAP -------------
        List<Employee> employees = new ArrayList<>();

        // Group employees by department
        Map<Department, List<Employee>> byDept = employees.stream()
                                                    .collect(Collectors.groupingBy(Employee::getDepartment));

        // Compute sum of salaries by department
        Map<Department, Integer> totalByDept = employees.stream()
                                                    .collect(Collectors.groupingBy(Employee::getDepartment,
                                                    Collectors.summingInt(Employee::getSalary)));

        // Partition employees into passing and failing the A band for annual appraisal
        Map<Boolean, List<Employee>> passingFailing = employees.stream()
                                                        .collect(Collectors.partitioningBy(s -> 
                                                        s.getGrade() >= 4.0));
           
    }

    public class Department {}
    public class Employee {
        Department department;
        int salary;
        double grade;
        Department getDepartment(){return department;}
        int getSalary() {return salary;}
        double getGrade(){return grade;}
    }
    
}
