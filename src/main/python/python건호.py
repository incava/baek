# korean, english, mathematics, science =  map(int,input().split())
# if 0 <= korean <= 100 and 0 <= english <= 100 and 0 <= mathematics <= 100 and 0 <= science <= 100:
#     if (korean + english + mathematics + science)/4 >= 80: #합격인지 확인
#         print("합격") #합격
#     else:
#         print("불합격") #불합격
# else:
#     print('잘못된 점수')


# if korean < 0 or korean > 100 or 0 > english > 100 or 0 > mathematics > 100 or 0 > science > 100:
#     print('잘못된 점수')
# elif (korean + english + mathematics + science)/4 >= 80: #합격인지 확인
#     print("합격") #합격
# else:
#     print("불합격") #불합격
queue = [1,2,3,4,5]
queue.pop(0) #스택 
print(queue)
queue.pop()
print(queue)
queue.append(7)
print(queue)