# demo
最小案例

service batch插入如果使用batch size为默认值会出现同时入库两条的情况，，类似于拼接sql：
```
INSERT INTO tablename ('username','password') values ('xxx','xxx'),('xxx','xxx')
```
而且这会导致自定义拦截器某一条数据无法拦截处理

