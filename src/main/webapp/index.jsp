<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Interface</title>
    <style>
        /* General styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f5f5f5;
        }

        /* Login container */
        .login-container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 40px; /* Increased padding */
            width: 400px; /* Increased width */
            text-align: center;
        }

        /* Title */
        .login-container h1 {
            margin-bottom: 20px;
            color: #333;
            font-style: italic; /* Italic font style */
        }

        /* Form elements */
        .login-container select,
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: calc(100% - 24px); /* Adjusting width for border */
            padding: 12px;
            margin-bottom: 15px;
            border: none;
            border-bottom: 2px solid #ccc;
            background-color: #f9f9f9;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
            transition: border-bottom-color 0.3s ease;
        }

        .login-container select:focus,
        .login-container input[type="text"]:focus,
        .login-container input[type="password"]:focus {
            outline: none;
            border-bottom-color: #007bff;
        }

        /* Login button */
        .login-container button {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 4px;
            background-color: #59ba8e;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .login-container button:hover {
            background-color: #59ba8e;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h1>Welcome to <i>Maktba</i></h1>
    <form action="login" method="POST">
        <select name="role" required>
            <option value="" disabled selected>Choose your role</option>
            <option value="admin">Admin</option>
            <option value="teacher">Teacher</option>
            <option value="print_agent">Print Agent</option>
        </select>
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>
