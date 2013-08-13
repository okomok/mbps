

package okomok.mbps.makro


import scala.reflect.macros.Context


trait MacroAnnotationImpl {
    final def impl(c: Context)(annottees: c.Expr[Any]*): c.Expr[Any] = {
        import c.universe._
        c.Expr[Any](Block(_impl(c)(annottees.map(_.tree).toList), Literal(Constant(()))))
    }

    protected def _impl(c: Context)(from: List[c.Tree]): List[c.Tree]
}