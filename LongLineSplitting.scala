object LongLineSplitting {

  case class Foo(field1 : String, field2 : String, field3 : Int, field4 : Double)

  def concatFoos(foo1 : Foo, foo2 : Foo) : Foo = {
    Foo(
      foo1.field1 + foo2.field1,
      foo1.field2 + foo2.field2,
      foo1.field3 + foo2.field3,
      foo1.field4 + foo2.field4
    )
  }

  def myFunction1() : Unit = {
    println(
      concatFoos(
        Foo("foo", "sha", 10, 3),
        Foo(
          "bar",
          "baz",
          10,
          0.14159
        )
      )
    )
  }

  def myFunction2() : Unit = {
    val list = List("foo", "bar", "sha", "baz")
    println(
      list.filter(_.length > 2).map(str =>
        if(str == "foo") {
          str.toUpperCase
        } else {
          str.toLowerCase
        }
      ).reduce((left, right) =>
        s"$left,$right"
      )
    )

    println(
      list.filter(_.length > 2).
        map(str =>
          if(str == "bar") {
            str.toUpperCase
          } else {
            str.toLowerCase
          }
        ).
        reduce((left, right) =>
          s"$left,$right"
        )
    )

    println(
      list.filter(_.length > 2).
        map(str =>
          if(str == "sha") {
            str.toUpperCase
          } else {
            str.toLowerCase
          }
        ).reduce(_ + "," + _)
    )
  }

  def main(args : Array[String]) : Unit = {
    myFunction1()
    myFunction2()
  }

}
