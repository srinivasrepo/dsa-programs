package DataStructures;

public class StreamApiExample {

    public static void main(String[] args) {
        
    }
}

/* 



STREAM METHODS
===============
Stream can only be used once. We cannot re-use stream variable second time.

STREAM CONVERSION
————————————-
IntStream.of(1,2,3) or IntStream(int[])
Arrays.stream(arr)
Stream.of(ele1, ele2 …..) or Stream.of(arr or lst)
list.stream() or map.stream() or set.stream()


METHODS
—————-
Stream.concat(Stream1, Stream2)
.of(ele) or .of(eles) or .of(arr or lst)
.filter(Predicate)
.allMatch(Predicate)
.anyMatch(Predicate)
.noneMatch(Predicate)
.peek(Consumer)
.forEach(Consumer)
.forEachOrdered(Consumer)
.findAny()
.findFirst()
.count() - size
.distinct()
.empty()
.limit(intMaxSize)
.skip(longVal)
.min(Comparator)
.max(Comparator)
.sum() or collect(Collectors.summingInt(Integer::intValue))
.reduce(BinaryOperator accumulator)
.reduce(T identity, BinaryOperator)
.reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
.sorted()
.sorted(Comparator)
.builder()
.peek(Consumer)
.toArray()
.toArray(IntFunction<A[]> generator)
.map(Function)
.mapToInt()
.mapToDouble(ToDoubleFunction)
.mapToLong(ToLongFunction)
.flatMap(Function<T, Stream> mapper)
.flatMapToInt(Function<T, IntStream>)
.flatMapToDouble(Function<T, DoubleStream>)
.flatMapToLong(Function<T, LongStream>)
.collect(Collector)
.collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner
.boxed() —- to arrays int stream to Integer Stream

Java 9 methods
.ofNullable(ele)
.takeWhile(Predicate)
.dropWhile(Predicate)
.iterate(seed, UnaryOperator)
.iterate​(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)

Java 16 methods
.mapMulti()
.mapMultiToInt()
.mapMultiToDouble()
.mapMultiToLong()
.toList() — to immutable list

Java 22 methods
.gather(GathererInPreview)

Methods inherited from interface java.util.stream.BaseStream
.close()
.onClose()
.isParallel()
.parallel()
.iterator()
.spliterator()
.sequential()
.unordered()



 */