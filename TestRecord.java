public record TestRecord(int foo, String bar) {
    TestRecord setFoo(int newFoo){
        return new TestRecord(newFoo,  bar); 
    }
    TestRecord setbar(String newBar){
        return new TestRecord(foo,  newBar); 
    }
    public TestRecord{}
}
