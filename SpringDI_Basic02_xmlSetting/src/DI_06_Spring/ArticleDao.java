package DI_06_Spring;

//Oracle, Mysql 이 사용되는 공통함수(추상함수) 강제구현
public interface ArticleDao {
	void insert(Article article);
}
