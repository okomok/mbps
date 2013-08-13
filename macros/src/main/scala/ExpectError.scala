

package okomok.mbps.makro

import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros.{Context, TypecheckException}


class expectError extends StaticAnnotation {
    def macroTransform(annottees: Any*) = macro _expectError.impl
}


object _expectError extends MacroAnnotationImpl {
    override protected def _impl(c: Context)(from: List[c.Tree]): List[c.Tree] = {
        import c.universe._

        val ValDef(_, _, _, rhs) :: _ = from

        try {
            c.typeCheck(rhs)
            c.abort(c.enclosingPosition, "Compiles unexpectedly:\n" + from)
        } catch {
            case e: TypecheckException => {
            }
        }

        List(EmptyTree)
    }
}