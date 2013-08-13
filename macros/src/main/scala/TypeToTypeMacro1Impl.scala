

package okomok.mbps.makro


import scala.reflect.macros.Context


// type xxx = arg --> type xxx = _apply(arg)
trait TypeToTypeMacro1Impl extends MacroAnnotationImpl {
    final override protected def _impl(c: Context)(from: List[c.Tree]): List[c.Tree] = {
        import c.universe._

        val ret = from match {
            case TypeDef(mod, name, _, rhs) :: _ => {
                val v = q"null.asInstanceOf[$rhs]" // typeCheck needs a term expression.
                val arg = c.typeCheck(v).tpe
                TypeDef(mod, name.toTypeName, Nil, TypeTree(_apply(c)(arg)))
            }
        }

        List(ret)
    }

    protected def _apply(c: Context)(arg: c.Type): c.Type
}