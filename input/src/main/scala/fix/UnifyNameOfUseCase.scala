/*
rule = UnifyNameOfUseCase
*/
package fix

import usecase.Usecase1
import usecase.{Usecase2 => UsecaseTwo}

object UnifyNameOfUseCase{
  val usecaseVal: Int = 1
  val fooUsecaseVal = 2
  var usecaseVar = 3
  var fooUsecaseVar = 4
  def usecaseDef = 5
  def fooUsecaseDef = 6
  case class UsecaseCls()
  case class FooUsecaseCls()
  object UsecaseObj
  object fooUsecaseObj
  type UsecaseType = Int
  type FooUsecaseType = Int

  def foo(usecase: UsecaseCls): FooUsecaseCls = FooUsecaseCls()

  val a: UsecaseObj.type = {
    println("singleton")
    UsecaseObj
  }
}

package object usecase {
  final case class Usecase1()
  final case class Usecase2()
}
