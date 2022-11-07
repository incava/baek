N = int(input())
def HanoiTop(N,frm,by,to):
    if N == 1:
        print(frm,to)
    else:
        HanoiTop(N-1,frm,to,by) #frm = 출발지  to 도착지  by = temp 
        print(frm,to)
        HanoiTop(N-1,by,frm,to) 
print(2**N -1)
HanoiTop(N,1,2,3)