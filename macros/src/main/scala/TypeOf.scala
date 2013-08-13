

package okomok.mbps.makro

import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros.Context


class typeOf extends StaticAnnotation {
    def macroTransform(annottees: Any*) = macro _typeOf.impl
}


object _typeOf extends TermToTypeMacro1Impl {
    override protected def _apply(c: Context)(arg: c.Tree): c.Type = {
        arg.tpe.widen
    }
}