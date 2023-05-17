package fix

import usecase.UseCase1
import usecase.{UseCase2 => UseCaseTwo}

object UnifyNameOfUseCase{
  val useCaseVal: Int = 1
  val fooUseCaseVal = 2
  var useCaseVar = 3
  var fooUseCaseVar = 4
  def useCaseDef = 5
  def fooUseCaseDef = 6
  case class UseCaseCls()
  case class FooUseCaseCls()
  object UseCaseObj
  object fooUseCaseObj
  type UseCaseType = Int
  type FooUseCaseType = Int

  def foo(useCase: UseCaseCls): FooUseCaseCls = FooUseCaseCls()

  val a: UseCaseObj.type = {
    println("singleton")
    UseCaseObj
  }
}

package object usecase {
  final case class UseCase1()
  final case class UseCase2()
}
