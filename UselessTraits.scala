object UselessTraits {

  trait Foo {
    def execute(input : String) : String
  }

  def myFunction(foo : Foo) : String = {
    foo.execute("Blah")
  }

  def myFunction2(foo : String => String) : String = {
    foo("Blah")
  }

  trait Foo2 {
    def foo() : String
    def bar() : String
  }

  class Foo2Impl(fooValue : String, barValue : String) extends Foo2 {
    override def foo() : String = fooValue

    override def bar() : String = barValue
  }

  def myFunction3(foo2 : Foo2) : String = {
    foo2.foo() + ":" + foo2.bar()
  }

  class Foo3(fooValue : String, barValue : String) {
    def foo() : String = fooValue
    def bar() : String = barValue
  }

  def myFunction4(foo3 : Foo3) : String = {
    foo3.foo() + ":" + foo3.bar()
  }

  def main(args : Array[String]) : Unit = {
    println(myFunction(new Foo() {
      override def execute(input : String) : String = input.toLowerCase
    }))
    println(myFunction2(foo => foo.toLowerCase))
    println(myFunction3(new Foo2Impl("My Foo", "My Bar")))
    println(myFunction4(new Foo3("My Foo", "My Bar")))
  }

}
