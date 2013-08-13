

package okomok.mbpstest



class NothingTypeTest extends org.scalatest.junit.JUnit3Suite  {

    implicitly[Nothing <:< Nothing with Int]

    implicitly[Nothing with Int <:< Nothing]

    implicitly[Nothing =:= Nothing with Int]

    def foo: Nothing with Int = (throw new Error) : Nothing with Int

    def testTrivial {

        try {
            foo
        } catch {
            case x: Error => ()
        }
    }


}
