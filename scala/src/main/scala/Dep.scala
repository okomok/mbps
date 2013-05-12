
package okomok.mpbs


object PathDepType {

    trait Able {
        type A // abstract type member
    }

    trait a extends Able {
        override type A = Int
    }

    trait b extends Able {
        override type A = Char
    }

    implicitly[Int =:= a#A]
    implicitly[Char =:= b#A]

    object c extends Able {
        override type A = String
    }

    implicitly[c.A =:= c.type#A]
    implicitly[c.A =:= String]

    def id(x: AnyRef): x.type = x

    val s: String = id("hello")

    def foo(a: Able): a.A = ???

    type A[a <: Able] = a#A

    trait PathDepFun[A[_]] {
        def apply(a: Able): A[a.type] = ???
    }
}



object SingType {
    object x {
        val y: String = ""
    }

    implicitly[x.y.type <:< String] // ~ type(x.y)
}




