

package okomok.mbps.makro


import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros.Context


class abandon extends StaticAnnotation {
    def macroTransform(annottees: Any*) = macro _abandon.impl
}


object _abandon extends MacroAnnotationImpl {
    override protected def _impl(c: Context)(from: List[c.Tree]): List[c.Tree] = {
        import c.universe._
        List(EmptyTree)
    }
}