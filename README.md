# mobile-tracker

- 본인의 repository로 fork 하세요.
- 프로젝트를 생성하고 아래 제시된 기능들을 구현해보세요.
- 최종 제출은 pull request(본인 github 계정명의 branch)로 대체합니다.
- 기한 내에 완성하지 못하더라도 해볼 수 있는 데 까지 해보세요. 빌드와 실행은 성공해야 합니다.

## Making simple tracker

- 아래의 references 에 제공된 링크들을 참조하세요.

### Scene #1
- ICON JSON RPC 3.0을 이용하여 가장 마지막에 생성된 10개의 block을 가져오고 화면에 출력합니다.
- 화면 출력은 내림차순을 기본으로 정렬합니다.
- 화면 맨 아래에 Pull to refresh를 구현하세요. 마지막으로 가져온 블럭의 다음 블럭부터 10개씩 가져오세요.
- 각 항목을 표시할 때 block_hash를 title로 사용해주세요.
- 각 항목은 복수 선택 가능하며 선택된 항목은 DB에 저장할 수 있습니다.

### Scene #2
- 항목을 선택할 경우 해당 항목의 confirmed_transaction_list의 내용들을 상세히 보여주세요.
- confirmed_transaction_list의 from, to, txHash를 title로 화면에 출력합니다.

### Scene #3
- 항목을 선택할 경우 해당 항목의 txHash로 transaction 결과를 받아오고 화면에 출력합니다.

### Scene #4
- DB에 저장된 내용을 확인합니다.

### Noticed
**Android와 iOS가 기본적으로 제공하는 API만을 사용합니다.**

```
Android의 경우 Room을 사용하여 DB를 구성, iOS의 경우 CoreData를 사용하세요.
```

제시된 기능을 완성하지 못하더라도 자신이 할 수 있는 부분을 최대한 구현해보세요.
UI/UX 구성 역시 평가 대상 항목입니다.

## References

- [ICON JSON RPC 3.0](https://github.com/icon-project/icon-rpc-server/blob/master/docs/icon-json-rpc-v3.md)
- [ICON Network](https://github.com/icon-project/icon-project.github.io/blob/master/docs/icon_network.md)
