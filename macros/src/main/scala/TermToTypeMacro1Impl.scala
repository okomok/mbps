

package okomok.mbps.makro


import scala.reflect.macros.Context


// val xxx = arg --> type xxx = _apply(arg)
trait TermToTypeMacro1Impl extends MacroAnnotationImpl {
    final override protected def _impl(c: Context)(from: List[c.Tree]): List[c.Tree] = {
        import c.universe._

        val ret = from match {
            case ValDef(mod, name, _, rhs) :: _ => {
                val arg = c.typeCheck(rhs)
                TypeDef(mod, name.toTypeName, Nil, TypeTree(_apply(c)(arg)))
            }
        }

        List(ret)
    }

    protected def _apply(c: Context)(arg: c.Tree): c.Type
}