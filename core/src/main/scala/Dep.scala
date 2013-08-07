
package okomok.mpbs


object PathDepType {

    trait K {
        type A // abstract type member
    }

    trait a extends K {
        override type A = Int
    }

    trait b extends K {
        override type A = Char
    }

    implicitly[Int =:= a#A]
    implicitly[Char =:= b#A]

    object c extends K {
        override type A = String
    }

    implicitly[c.A =:= c.type#A]
    implicitly[c.A =:= String]

    def id(x: AnyRef): x.type = x

    val s: String = id("hello")

    def foo(a: K): a.A = ???

    type A[a <: K] = a#A

    trait PathDepFun[A[_]] {
        def apply(a: K): A[a.type] = ???
    }
}


