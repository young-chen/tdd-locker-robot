# Locker Robot业务系统迭代一

### Task - 存包

1. Given 剩余 15 个空位 When 存包 Then 返回一个带有空位编号的票据
2. Given 剩余15 个空位 When 存包 Then 剩余 14 个空位
3. Given 剩余 0 个空位 When 存包 Then 提示柜子已满
4. Given 剩余 0 个空位 When 存包 Then 剩余 0 个空位
5. Given 14 号位已被占用 When 存包 Then 提示该位已被占用
6. Given 15 号位空闲 When 存包 Then 提示可以使用 

### Task - 取包

1. Given 剩余 0 个空位 When 取包 Then 剩余1 个空位
2. Given 剩余 0 个空位 When 取包 Then 票据失效
3. Given 失效票据 When 取包 Then 提示票据已失效
4. Given 失效票据 When 取包 Then 剩余空位数不变
5. Given 有效的 15 号位编号票据 When 取包 Then 15 号位状态为空闲

