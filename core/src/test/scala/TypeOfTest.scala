

package okomok.mbpstest

import okomok.mbps.makro._


class TypeOfTest extends org.scalatest.junit.JUnit3Suite {

    trait A
    object B extends A

    class My {
    }

    def id[x](x: x) = x

    def testTrivial {

        val k = 3
        @typeOf val pkk = 3
        implicitly[pkk =:= Int]

        // the context doesn't contain k.
        val x = new { @typeOf val apply = k }
        implicitly[x.apply =:= Int]

        val y = new { @typeIdentity type apply = List[Int] }
        implicitly[y.apply =:= List[Int]]

        @abandon
        def p = hello

        @expectError
        val _ = k

        new {
            @expectError
            val _ = {
                wowow
            }
        }

        @abandon
        @inline def foo = ()

        val ss: String = Material(3)
        println(ss)


    //    type k = { type k = Int; @identity type t = Int }

    }


}
