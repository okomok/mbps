

package okomok.mbps.makro

import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros.Context


class identity extends StaticAnnotation {
    def macroTransform(annottees: Any*) = macro identity_.impl
}


object identity_ {
    def impl(c: Context)(annottees: c.Expr[Any]*): c.Expr[Any] = {
        import c.universe._
        c.Expr[Any](Block(annottees.map(_.tree).toList, Literal(Constant(()))))
    }
}