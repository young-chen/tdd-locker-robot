# Locker Robot业务系统迭代一

### Task - 存包

1. Given 储物柜有多个可用空间 When 存包 Then 返回一个票据, 可用空间数量减一
2. Given 储物柜没有可用空间 When 存包 Then 提示没有可用空间

### Task - 取包

1. Given 一个未使用过的票据 When 取包 Then 可以成功释放对应的空间，空间数量加一
2. Given 一个使用过的票据 When 取包 Then 提示票据无效

