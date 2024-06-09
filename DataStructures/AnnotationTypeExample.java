package DataStructures;

/* 
In annotation type interface we can only use methods with return type as primitives, String, Array of primitives. 
We cannot use Non-primitives or classes or list.
 */
import java.lang.annotation.ElementType;
import java. lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java. lang. annotation.Target;


@Retention(RetentionPolicy.RUNTIME) // optional
@Target({ElementType.METHOD, ElementType.FIELD}) // optional
public @interface AnnotationTypeExample {
    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    String[] reviewers(); // Note use of array
    double PI = 3.14; // static constant variable

/*     String test(){   // Syntax error on token ")", default expected after this tokenJava(1610612967)
        return "test";  // i.e we can only have default value but not the default method in @interface
    } */
}
/* 
which can then annotate a class as follows:
@AnnotationTypeExample (       //The annotation @AnnotationTypeExample is disallowed for this location or same file
   author = "John Doe",
   date = "3/17/2002",
   currentRevision = 6,
   lastModified = "4/12/2004",
   lastModifiedBy = "Jane Doe",
   // Note array notation
   reviewers = {"Alice", "Bob", "Cindy"}
)
public class Generation3List extends Generation {
      // class code goes here
}
*/



/*
Annotation Types basically don’t change our code in real-time but will helpful in the runtime. Annotations can be class level @Path, method level @Override or variable level @SuppressWarnings. And will defining our custom annotations we use some in-built or another custom annotations. This custom annotation’s in-built annotations are 
1) @Target(“ClassMethodVarLevel”) - optional and leave it if you want to use this for all levels. Inside value is like ElementType.METHOD, .TYPE(class), .PACKAGE., .CONSTRUCTOR, .FIELD(variable)
2) @Retention(RetentionPolicy.RUNTIME) to keep this annotation alive up to what extent i.e annotation life cycle. RUNTIME means alive all the way through runtime, so that other code can use this annotation. Other values like RetentionPolicy.SOURCE means make alive even before the code is complied like SuppressWarning annotation, RetentionPolicy.CLASS means only active up to compile and destroys at runtime.
3) @Documented......
We can check whether a class is annotated or not by
myClass.getClass().isAnnotationPresent(CustomAnnotation.class);
That is how all the project classes are looped to check for @Configuration annotations classes and again each configClass is looped with all it’s methods to check the @Bean methods then the Spring executes all the beans methods (using Method.invoke()) when our Spring application starts running.
We can pass arguments to custom annotations. We know that interface can only have static and constant variables. So, make them as methods but can be used in @RunImmediately(times=3)
for (Method method : myCat.getclass.getDeclaredMethods()){
    if (method.isAnnotationPresent(RunImmediately.class)){
        RunImmediately annotation = method.getAnnotation(RunImmediately.c
        for (int i = 0; i ‹ annotation.times); i++){ method. invoke(myCat); }
    }
} 
    

*/
