#part 2 @6:12 in addition to flask, render_tempalte we also want flash (flash messages), redirect, url_for, session, logging
from flask import Flask, render_template, flash, redirect, url_for, request, session, logging
#part 1 @21:40 Now we can import the Articles from data. (part 4 @19:55 this gets commented out, replaced with mysql)
# from data import Articles
#part 2  @6:31 import db:
from flask_mysqldb import MySQL
#part 2  @6:46 WT-forms, we are going ti import that and each type of field we are going to use.
from wtforms import Form, StringField, TextAreaField, PasswordField, validators
#part 2 @7:22 now we want to import passlib.hash for encrypting our password.
from passlib.hash import sha256_crypt
#part 3 @27:16 After this we are done and we can try to use the login portion.
from functools import wraps


#Part 1 We then want to create an instance of the flask app. The "__name__" is essentially a placeholder for the card module, 
app = Flask(__name__)
#Part 1 This is asking if this is equal to main because that is the script that is being executed. Then we want to run the app.


#part 2  @21:20 We want to configure our MySQL to work correctly and so this program knows what sql to use.
app.config['MYSQL_HOST'] = 'localhost'
app.config['MYSQL_USER'] = 'root'
app.config['MYSQL_PASSWORD'] = '1234' 
#part 2 The database we want to use, which is myflaskapp unless you called it something diff
app.config['MYSQL_DB'] = 'myflaskapp'
#part 2 @22:39 he explains the cursor, which we can use the cursor method to execute and run our queries, these return tupels which is a certain data type in python. We want to return a dictionary. So we want to set the default cursor class to dictionary, so we use "DictCursor"
app.config['MYSQL_CURSORCLASS'] = 'DictCursor'
#part 2 @23:56 Now we initialize MySQL, we just want to use MySQL and wrap it up in the app variable. Now we can use this to create our cursors and create videos. Now we go down to register
mysql = MySQL(app)
 

#Part 1 @22:00 we are going to set articles to be that articles function, which is pointing to the return value given in data.py (part 4 @19:55 this gets commented out, replaced with mysql)
# Articles = Articles()


#Part 1 @8:10 he runs it. Then he goes to "localhost:5000" to get everything started. We get a not found and the reason for that is because we haven't created a "route". So we put in the slash '/' because thats the route. WE are going to create a function inside the app.route and return a string called "INDEX". You have to restart the server though(stopping terminal), to just refresh you have to put the app "debug = true" in the pass through or you can make a variable"app.debug = True" for it above. 
#app.debug = True
@app.route('/')
def index():
#Part 1 @10:19 as youy can see its easy to create a route, but normally we would return a template and not a "String". So to do that we import the "render_template". Then we just return the "render_template()" func and pass in a "home.html". 
  return render_template('home.html')

#Part 1 @18:04 now we are creating the route for "about.html" or the hrefs using "/about". After this we create the html file for this(go to about.html).
@app.route('/about')
def about():
  return render_template('about.html')


#Part 1 Now we will be creating a new route @22:25, we are going to be returning a reder_template but we also want to be passing in the data "articles = Articles". Then create a articles.html file and go to it @22:55
@app.route('/articles')
def articles():
#Part 4 @19:08 Now lets makes it that the front end of the article list will retrieve articles from the database.  
    cur = mysql.connection.cursor()
    result = cur.execute("SELECT * FROM articles")
    articles = cur.fetchall()
    
    if result > 0:
        return render_template('articles.html', articles = articles)
    else:
        msg = "No Articles Found"
        return render_template('articles.html', msg = msg)

    cur.close()



#Part 1 @25:54 Now all we did was copy the articles route above and then just pasted it below(change name from articles to article). What we are going to do is grab the value of of id that is a string. then we can pass in "id" into the function and use it. later on we will take this id and make a query to MySQL to fetch that particular article and then pass it along. Since we aren't using MySQL yet, we will just pass off the id itself(id = id)@27:00 we also have to change it in the article.html (go to articles.html and change articles/... to article/...). @27:11, last thing we need to do is to create the actual template(create article.html) for this to work. 
@app.route('/article/<string:id>/')
def article(id):
    #Part 4 @20:00 Now we want to do the single article page. That way we can click on whatever article and view it. To do this we will grab the code below and change the result to query the result WHERE id = "%s" and that is going to be replaced with id. Then change the articles to article and so on. @21:35 (go to article.html)
    cur = mysql.connection.cursor()
    result = cur.execute("SELECT * FROM articles WHERE id = %s",[id])
    article = cur.fetchone()
    return render_template('article.html', article = article)



#part 2  @7:40 Now we are going to have to create a registering route as well. So we go to wtforms.readthedocs.io
class RegisterForm(Form):
#part 2 Now we want name, with a readable name, and validators to check for lengths min of 1 and max of 50.
    name = StringField('Name', [validators.Length(min=1, max=50)])
    username = StringField('Username', [validators.Length(min=4, max=25)])
    email = StringField('Email', [validators.Length(min=6, max=50)])
#part 2 @10:17 for this we will be having alot of validators. One will be a password one will be a a confirm, we want these two fields.
    password = PasswordField('Password', [
        validators.DataRequired(),
        validators.EqualTo('confirm', message='Passwords do not match')
  ])
#part 2 @11:02 finally we are going to have a confirm field and a label of "Confirm Password" and this should do it for password field. 
    confirm = PasswordField('Confirm Password')



#part 2 @11:22 Now we need a route. Now with the other routes, we wanted to just "get" request to post content when called. With this we want the same plus the fact that we want to have post requests. For that we need to describe methods which will be get and post
@app.route('/register', methods = ['GET','POST'])
def register():
#part 2 @12:19 we are going to create a form variable and set it equal to the RegisterForm we just created and its going to pass through request.form. Now request is actually something that needs to be brought in(imported). 
    form = RegisterForm(request.form)
#part 2 @12:55 Now we need to check if this is a get request or a post request AND we want to make sure the form is validated.   
    if request.method == 'POST' and form.validate():
#part 2 @24:26 Now if its post, then we want to get the form values. Name, Email, Username and Password. The password we need to encrypt before we send it. So we need to wrap it in a function for encryption using the import and make sure to wrap it in str to convert it
      name = form.name.data
      email = form.email.data
      username = form.username.data 
      password = sha256_crypt.encrypt(str(form.password.data))


#part 2 26:03 Now we are going to create the cursor to use. Now we can use it to execute commands, like an insert statement. In the cur.execute, we also want four percentage signs, which will be placeholders that are going to be replaced with what we put in next, which are going to be all the variables after the comma that we asigned up above. 
      cur = mysql.connection.cursor()
      cur.execute("INSERT INTO users(name, email, username, password) VALUES(%s, %s, %s, %s)", (name, email, username, password))
#part 2 @27:56 Now we are commiting to DB
      mysql.connection.commit()
#part 2 @28:08 close the connection
      cur.close()
#part 2 @28:25 We also want a flash message to confirm our registration, we can also create catagories, so this is a "success" message. Also this is only a place to initialize it, we now need a place to actually show up. @29:30 so we make another include, called "_messages.html" (go to messages.html)
      flash("you are now registered and can login", "success")
#part 2 @29:00 We also want to redirect
      redirect(url_for('index'))
#part 2 @13:40 return the render and pass in the file we return and then the form. @14:06 we creat a new file called register.html(go to it) @15:11 he runs the code, types in "localhost:5000/register" on url and it says "register". which means it works. @15:17 go to the register.html form 
    return render_template('register.html', form = form)


#part 3  @:30 We are now going to be taking care of the user login portion.WE are going to add an app.route and we also want to add in the post and get methods to retrieve everything needed. Just like we did registration we have to see if the method is post. @1:40 So if the form is submitted, so we want to get a user name and password. we are not using WT forms like we did with registration, we are just getting the user value differently.
@app.route('/login', methods=['GET','POST'])
def login():
    if request.method == 'POST':
        username = request.form['username']
#part 3 2:38 we are jsut going to call this password candidate. We put candidate because we want the actual password we get from the database.
        password_candidate = request.form['password'] 
   
#part 3 3:09 now we need to create a cursor. 
        cur = mysql.connection.cursor()
#part 3  3:27 now we want to get the user by the username. So we are going to create this variable and set it to the SQL query to get the user. Now we do the query then we use the "%s" symbol and then next parameter is what that "%s" is going to be.
        result = cur.execute("SELECT * FROM users WHERE username = %s", [username])

#part 3  now we aree going to check the results, by this we are going to see if there is any rows found. then we are going to get the stored hash. @4:48 Now what this does is it looks at the query for the "result" variable and matches the first one it finds and thats what it will take. It's only going to "fetch one". So even if there were more users with that username, its just going to get the first one and then we get the password from that query. @5:10 Remember we are treating this as a dictionary. So by default, it's going to return a "tupel"
        if result > 0:
            data = cur.fetchone()
            password = data['password']

#part 3 @5:42 Now what we want to do is just compare the passwords, for now we are just going to log whethere this passes or fails. by using "app.logger.info()":
            if sha256_crypt.verify(password_candidate,password):
#part 3 @14:31 If the password and username passes what we want to do is going to be to make sure that the program knows that a session is actived and on. We also want the username stored in the session. We then flash a message confirmin the log in adn trhen we are going to be returning a rediredct(url_for('dashboard')), which we have not created yet.
				# app.logger.info('PASSWORD MATCHED')
                session['logged_in'] = True
                session['username'] = username
                flash('You are logged in','success')
                # We want to use redirect over render_template because we are redirecting and changing URLs.
                return redirect(url_for('dashboard'))
#part 3 @9:36 We then want to add the else statement to keep track of the login usage.This is to show that the logic is all there for the login and now we just need to load the templates and then we want to create our "session". We want to store the username in a session as well.  
            else:
#part 3 @10:18 Now all we want to do is return the template to make sure that there is no user found. On top of that we also want to pass in the error. Then copy and past that for the other else. @11:12 We need to output this error somewhere in the template, so go to the file (_messages.html).
        # app.logger.info('PASSWORD NOT MATCHED')
                error = 'Invalid Login'
                return render_template('login.html',error=error)
#part 3 15:49 we also wwan to close the connection.
            cur.close()
#part 3 @6:50 Now if "result > 0" is false, that means there wasn't even a user with that name. @7:21 We create the login.html file and go to that(login.html).
        else: 
# app.logger.info('NO USER WITH THAT USERNAME')
            error = 'Username is not found' 
            return render_template('login.html',error=error)

    return render_template('login.html') 


#part 3 @24:18 We are not going to check to see if we are logged in so we can access the dashboard. We will be creating a function and we are going to be passing in a parameter of "f". Then wraps with the parameter of "f". Then we put that "weird args and kwargs" thing.
def is_logged_in(f):
    @wraps(f) #Bring wraps in, Import!
    def wrap(*args, **kwargs):
        if 'logged_in' in session:
            return f(*args, **kwargs)
        else:
            flash("Unauthorized, invalid", "danger")
            return redirect(url_for('login'))
    return wrap


#part 3 18:18 We also want to create a logout and then at @19:58 we want to put that into our html (@20:08 go to _navbar.html). (part 4 @5:05 he puts the "@is_logged_in" in there)
@app.route('/logout')
@is_logged_in
def logout():
    session.clear()
    flash("You are now logged out","Success")
    return redirect(url_for("login"))

#part 3 16:12 lets now create the dashboard for the redirect.
@app.route('/dashboard')
@is_logged_in
def dashboard():
    #Part 4 @13:09 Now at the dashboard, we want to see the articles we actually made just like we do on the articles page, which will change based on what has been posted. 
    #Part 4 13:30 So now we are going to create a cursor
    cur = mysql.connection.cursor()
    #Part 4 13:53 get articles
    result = cur.execute("SELECT * FROM articles")
    #Part 4 14:57 We then set a variable to articles and set it to cur.fetchall(), which will fetch it in dictionary form.
    articles = cur.fetchall()
    #Part 4 14:20 Then we want to check if the result is greator than 0, to see if there is any rows, we are going to render the template but we are also going to pass along the articles. If there is an else, we want to pass along a message stating there was nothing. :
    if result > 0:
        return render_template('dashboard.html', articles = articles)
    else:
        msg = "No Articles Found"
        return render_template('dashboard.html', msg = msg)

    #Part 4 @15:18 then we want to close to connection. @15:37 now we should have access to the articles from the dashboard template. (go to dashboard.html)
    cur.close()
 


#Part 4  @3:15 What we are going to do is copy the "RegisterForm" class and then paste it and do some changes to it.  We will delete of the variables. We then use MySQL 
class ArticleForm(Form):
    title = StringField('Title', [validators.Length(min=1, max=200)])
    body = TextAreaField('Body', [validators.Length(min=4)])
#Part 4 @4:31 Now we want to add the actual route, remember that this one can actually take a post so we want to use the "methods = ['GET','POST'], @Part 4 5:00 he also randomly puts a "@is_logged_in" in the logout as well. @5:33 What we then want to do is set the form to ArticleForm.
@app.route('/add_article', methods = ['GET','POST'])
@is_logged_in
def add_article():
    form = ArticleForm(request.form)
    #Part 4 @5:43 What we also want to do is check for the POST.  
    if request.method == 'POST' and form.validate():
    #Part 4 6:00 We then want to get the title from the forum and also the body.  
        title = form.title.data
        body = form.body.data
    #Part 4 6:13 We are also going to create a cursor 
        cur = mysql.connection.cursor()
    #Part 4 6:33 We want to execute this, this is going to be an insert and we want to insert into the article table. We are inserting a title, body, author. We are also having to set the values, which are going to be "replacements" so we use the percentages.@7:17 then we put a comma, open up a set of parenthesis, first one comes from the title, body, and the author is going to come from session and user name.(if you wanted to be more in depth, you can also fetch the real name too.): 
        cur.execute("INSERT INTO articles(title, body, author) VALUES(%s, %s, %s)", (title, body, session['username']))

        #Part 4 @8:02 Now we want to commit to the database and then we want to close it
        mysql.connection.commit()
        cur.close()

        #Part 4 @8:31 Then we send a flash message and then we want to redirect to the dashboard by returning a redirect
        flash('Article Created','success')
        return redirect(url_for('dashboard'))

    #Part 4 @8:56 We also need to render the template before we check for the post. For the second parameter we just need to pass in that form we made earlier, just like we did with the registrration.
    return render_template('add_article.html', form = form)
    
    #Part 4 @9:35 Now we need to actually create the "form" or article. Under templates we create a new file, which will be "add_article.html".(go to add_article.html)




#Part 5 00:00 Now we want to work on the editing of the articles. So we just copied the add_article function here. We are also going to be putting in the "<string:id>" to pass in variables to the app.route. Also we will be passing in the id as the parameter. 
@app.route('/edit_article/<string:id>', methods = ['GET','POST'])
@is_logged_in
def edit_article(id):
#@1:33 before we have the form we need to fill it. So we need to do some query to actually get the article by its id and then fill in that form with whats already in that article.
    cur = mysql.connection.cursor()

#2:08 Get the article by id, because the id is being passed in here. We then want to use a "fetchone" method to get the article.   
    result = cur.execute("SELECT * FROM articles WHERE id = %s", [id])
    article = cur.fetchone()
    cur.close()

# 3:00 We want to use this form. 
    form = ArticleForm(request.form)
    
# 3:12 We want to populate the fields and we can do this from here. We do this by form.title.data = article. So essentially we get the field from above and use that to grab the title and body and fill the field. 
    form.title.data = article['title']
    form.body.data = article['body']

    if request.method == 'POST' and form.validate():
        title = request.form['title']
        body = request.form['body']
        
        cur = mysql.connection.cursor()
        app.logger.info(title)
#3:50 Now we want to do everything above, but this time we want to update the form instead of inserting. 
        cur.execute ("UPDATE articles SET title=%s, body=%s WHERE id=%s",(title, body, id))

        mysql.connection.commit()
        cur.close()

        flash('Article Updated','success')
        return redirect(url_for('dashboard'))
# 6:07 After all this, we then (go to edit_article)
    return render_template('edit_article.html', form = form)


#10:07 Here we are adding the delete button functionality route. The id is going to get passed as well, make sure to put in the "<string:id>" to pass that in. 
@app.route("/delete_article/<string:id>") 
@is_logged_in
def delete_article(id):
    # We need to create our cursor as well. 
    cur = mysql.connection.cursor()

    # Execute
    cur.execute("DELETE FROM articles WHERE id = %s", [id])

    # Commit to DB
    mysql.connection.commit()

    #Close connection
    cur.close()

    flash('Article Deleted', 'success')

    return redirect(url_for('dashboard'))



if(__name__) == '__main__':
#part 2 @33:08 we needed to make a secret_key for the MySQL command can work. so we set it to something simple but should be better. HE then continues to make sure everything works and it does.
    app.secret_key = 'secret123'
    app.run(debug=True)

#Part 1 @10:50 Now we create a folder called "templates" because its going to look in there and then we create the home.html file inside of there. When we reload it reads from taht tempalte. 
#Part 1 @11:35 next thing we do is look at layouts. So we don't want to repeat ourselves and put html body, head, and whatever else in everysingle template. we want to have a layout where we can wrap the current view or template. so in templates create a new file called "layout.html". 
#Part 1 in there we have can include the general tags "!!!" shortcut, then title it "my flask app" and in the body we want to include the scripts.

