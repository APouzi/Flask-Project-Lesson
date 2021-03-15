#Part 1 19:50 We are jsut going to create articles for a function. We will have an array of dictionaries for the articles. Then we will be returning the articles. After this we go to "app.py" @21:40
def Articles():
    articles = [
        {
          'id' :1,
          'name':'article one',
          'body' : 'words words words, words words words, words words words, words words words, words words words',
          'author' : 'Alex Pouzikov',
          'create_date' : '04-25-2017'
        },
        {
          'id' :2,
          'name':'article two',
          'body' : 'words words words, words words words, words words words, words words words, words words words',
          'author' : 'Eshy Pouzikov',
          'create_date' : '04-25-2017'
        },   
        {
          'id' :3,
          'name':'article three',
          'body' : 'words words words, words words words, words words words, words words words, words words words',
          'author' : 'Alex Pouzikov',
          'create_date' : '04-25-2017'
        }
    ]
    return articles