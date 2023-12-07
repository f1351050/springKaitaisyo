# springKaitaisyo

# 1-3章メモ
# アノテーションメモ  
@GetMapping  
HTTPリクエストを受け付ける  
受け付けるURLを引数

@Model  
別の画面に値を渡すことができる  
ModelクラスのaddAttribureメソッドにキー名と値を指定  
addAttribute(キー名,値)   

@Data
以下のメソッドを自動で生成してくれる＝フィールド変更しても作り直す手間が省ける  
・gatter    
・setter   
・toString   
・hashCode   
・equals   

@Repository  
DB操作を表すリポジトリー

@Autowired  
Depenedency Injection（依存性の注入)を使うためのアノテーション   


# H2データベース初期化設定  
・spring.datasource.initialize  
　trueを選択すると、テーブル作成とデータ投入のSQLを実行してくれる  
・spring.datasource.chema  
　テーブル作成のSQLを実行してくれる    
・spring.datasource.data  
　初期データ投入のSQLを実行してくれる  
　プロパティに設定している[classpath:]はsrc/main/resouceのこと  


# ５章メモ
# DI(Dependency Injection)-依存性の注入  

# 依存とは  
以下のようなクラスが存在したとして  
例えば、引数で渡しているSomeObBのメソッドに引数を追加すると  
このクラスも修正しないけない。  
SomObAは、SomeObBに依存している  
[sample]
public class SomeObA{  
 private SomeObB obB;  
   
 public SomeObjA(SomeObB obB){  
  this.obB = obB;  
 }  

 publib void methodA{  
  obB.methodB();  
 }  

# 注入とは  
変数にインスタンスを代入すること  
インスタンス代入しないとb=nullのままでNullPointerExceptionが発生  
コンストラクターやsetterなどでインスタンスを代入
[sample]  
public somA(SomB b){  
 this.b = b  
}  

# 依存性の注入  
インターフェースや中小クラスを継承したクラスのインスタンスを代入すること  
例えば,Listインターフェースを実装したArrayListクラスを注入する場合
List<Object> list = new ArrayLisy<>();

# memo
・@RequestArgsConstructor   
コンストラクタも自動生成される  

・@AllArgsConstructor
全てのﾌｨｰﾙﾄﾞを引数荷物コンストラクタが作成される

・setterインジェクション
setterの引数に依存性を注入できる
stterに@Autowiredアノテーションをつける・・？
[sample]
@Component
public class Sample{
 private SampleComponent component;

 @Autowires
  public void setComponent(SampleComponent component){
  this.component = component; 
 }
}

# DIコンテナの落とし穴（全体的にわからなかった）
・singletonｽｺｰﾌﾟ  
・異なるｽｺｰﾌﾟ  
・Bean以外からはDIできない


# 6章メモ 
・webjarsとは
javascriptやCSSなどのライブラリをMavenで利用できるようにするライブラリ
　　
・webjars-locatioとは　
webjarsで使用するライブラリのバージョンを意識せずにコードを書けるかけるようになる  
※Bootstrapを使用するためにはjQueryが必要  

・@RequestMapping  
URLのプリフィックス（接頭辞）として利用できる

・RPGパターン
POST-Redirect-GET
POSTメソッドのあとにﾘﾀﾞｲﾚｸﾄして画面遷移(GETメソッド実行）すること
ﾘﾀﾞｲﾚｸﾄせずに画面遷移するｱﾌﾟﾘｹｰｼｮﾝがあるとすると、登録操作の直後に
ブラウザ上でF5を押すと同じリクエストを送り、また登録処理が行われる

参考文献
・DIコンテナ　
https://springhack.com/autowired-%EF%BC%88springboot%E3%81%AE%E3%82%A2%E3%83%8E%E3%83%86%E3%83%BC%E3%82%B7%E3%83%A7%E3%83%B3%EF%BC%89/#:~:text=%E5%8F%B3%E5%81%B4%E3%81%AE%E3%82%88%E3%81%86%E3%81%AB%E3%82%B3%E3%83%B3%E3%82%B9%E3%83%88%E3%83%A9%E3%82%AF%E3%82%BF%E3%83%BC%E3%82%92%E9%80%9A%E3%81%98%E3%81%A6%E3%82%A4%E3%83%B3%E3%82%B9%E3%82%BF%E3%83%B3%E3%82%B9%E3%82%92%E6%B3%A8%E5%85%A5%E3%81%99%E3%82%8B%E3%81%93%E3%81%A8%E3%82%92%E3%80%81,%E3%82%B3%E3%83%B3%E3%82%B9%E3%83%88%E3%83%A9%E3%82%AF%E3%82%BF%E3%82%A4%E3%83%B3%E3%82%B8%E3%82%A7%E3%82%AF%E3%82%B7%E3%83%A7%E3%83%B3%20%E3%81%A8%E8%A8%80%E3%81%84%E3%81%BE%E3%81%99%E3%80%82
