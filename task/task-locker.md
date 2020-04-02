# Locker Robot业务系统迭代一

### Task - 存包

1. Given 储物柜有多个空位 When 存包 Then 返回一个票据, 空位数量减一
2. Given 储物柜没有空位 When 存包 Then 提示柜子已满 

### Task - 取包

1. Given 一个未使用过的票据 When 取包 Then 可以成功取出对应的包，空位梳理加一
2. Given 一个使用过的票据 When 取包 Then 提示票据失效

