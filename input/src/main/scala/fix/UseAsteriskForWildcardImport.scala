/*
rule = UseAsteriskForWildcardImport
*/
package fix

import foo._
import hoge.{fuga, _}

object foo {
  object bar
}

object hoge{
  object fuga 
  object piyo
}
