def TF(word):
    i = 0
    stk = []
    while(word[i]!='.'):
        if word[i] == '(':
            stk.append('(')
        elif word[i] == '[':
            stk.append('[')
        elif word[i] == ']':
            if stk and stk[-1] == '[':
                stk.pop()
            else:
                return print('no')
        elif word[i] == ')':
            if stk and stk[-1] == '(':
                stk.pop()
            else:
                return print('no')
        i+=1
    return print('yes') if not stk else print('no')
       
while(True):
    word = input()
    if word[0] == '.': 
        exit()
    TF(word)