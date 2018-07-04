<style type = "text/css">
body {
    margin: 0;
    padding: 0;
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    color: #444;
}

html, body{height: 90%}
/*
 * Create dark grey header with a white logo
 */

header {
    background-color: #2B2B2B;
    height: 35px;
    width: 100%;
    opacity: .9;
    margin-bottom: 10px;
}

header h1.logo {
    margin: 0;
    font-size: 1.7em;
    color: #8b8878;
    text-transform: uppercase;
    float: left;
}

header h1.logo:hover {
    color: #8b8878;
    text-decoration: none;
}

.footer{
    font-size: 1.0em;
    color: #444;
    width: 100%;
}

/*
 * Center the body content
 */

.container {
    width: 940px;
    margin: 0 auto;
    min-height: 100%;
}

div.jumbo {
    padding: 10px 0 30px 0;
    background-color: #c6c2c2;
    -webkit-border-radius: 6px;
    -moz-border-radius: 6px;
    border-radius: 6px;
    min-height: 100%;
}

h2 {
    font-size: 3em;
    margin-top: 40px;
    text-align: center;
    letter-spacing: -2px;
}

h3 {
    font-size: 1.7em;
    font-weight: 100;
    margin-top: 30px;
    text-align: left;
    letter-spacing: -1px;
}

.menu {
    float: right;
    margin-top: 8px;
}

.menu li {
    display: inline;
}

.menu li + li {
    margin-left: 35px;
}

.menu li a {
    color: #999;
    text-decoration: none;
}
table{
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}

.square_btn {
    display: inline-block;
    padding: 0.3em 1em;
    text-decoration: none;
    color: black;
    border: solid 2px #999;
    border-radius: 3px;
    transition: .4s;
}

.square_btn:hover {
    background: #999;
    color: white;
}

.campo {
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    margin-bottom: 1em;
}

.campo label {

    margin-bottom: 0.2em;
    color: #666;
    display: block;
}

.campo select option {
    padding-right: 1em;
}
.check{
    display: block;
    position: relative;
    padding-left: 35px;
    margin-bottom: 12px;
    cursor: pointer;
    font-size: 22px;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}
.check input {
    position: absolute;
    opacity: 0;
    cursor: pointer;
}
.checkmark {
    position: absolute;
    top: 0;
    left: 0;
    height: 25px;
    width: 25px;
    background-color: #fff;
}
.check:hover input ~ .checkmark {
    background-color: #eee;
}
.checkmark:after {
    content: "";
    position: absolute;
    display: none;
}

.check input:checked ~ .checkmark:after {
    display: block;
}

/* Style the checkmark/indicator */
.check .checkmark:after {
    left: 9px;
    top: 5px;
    width: 5px;
    height: 10px;
    border: solid black;
    border-width: 0 3px 3px 0;
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    transform: rotate(45deg);
}

a.two:link, a:visited {
    background-color: white;
    color: black;
    border: 2px solid black;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
}

a.two:hover, a:active {
    background-color: black;
    color: white;
}

input[type=text] {
    width: 130px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
}

input[type=text]:focus {
    width: 100%;
}
</style>

<!DOCTYPE html>
<html>
<body>

<header>
    <div class="container">
        <h1 class="logo">control</h1>
        <strong><nav>
            <ul class = "menu">
                <li><a href="/home">Home</a></li>
                <li><a href="/aluno">Alunos</a></li>
                <li><a href="/turmas">Turmas</a></li>
            </ul>
        </nav></strong>
    </div>
</header>
<div class = "container">
    <@page_body>

    </@page_body>
</div>
</body>

  <div class = "footer">
      <p class align= "right"><strong>Ver.1.0</strong></p>
  </div>

</html>