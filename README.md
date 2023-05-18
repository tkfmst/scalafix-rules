# scalafix-rules

## To develop rule:

```
sbt ~tests/test
# edit rules/src/main/scala/fix/Scalafixrules.scala
```

## ルール一覧

0->9->A,a->Z,z->あ,ア->ん,ン順

### UnifyNameOfUseCase

- `UseCase` と言う名前の表記振れを修正
- 例
    - `usecase` -> `useCase`
    - `Usecase` -> `UseCase`

### UseAsteriskForWildcardImport

- `import`でワイルドカードを使う時、scala2の`_` ではなく `*` を使う
