<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
	
  String error = request.getAttribute("error").toString(); 
%>

<!DOCTYPE html>
<html lang="en">
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/tailwindcss@2.1/dist/tailwind.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/daisyui@1.14.0/dist/full.css"
      rel="stylesheet"
      type="text/css"
    />
    <title>サインイン</title>
  </head>

  <body>
    <form action="/SD/servlet/signin" method="POST">
      <div
        class="
          flex flex-col
          justify-center
          items-center
          w-full
          h-screen
          bg-gray-100
        "
        >

        <div class="flex flex-col w-96 mx-auto gap-2">
          <h1
            class="text-center text-2xl md:text-3xl font-medium text-gray-800"
          >
            サインイン
          </h1>
          
          <p class="pl-2 text-lg text-red-400">
            メールアドレスまたはパスワードが間違っています
          </p>

          <label for="email" class="pl-2 text-gray-600">
            メールアドレス
          </label>
          <input
            type="text"
            id="email"
            name="EMPLOYEE_EMAIL"
            class="input input-info input-bordered w-full"
          />

          <label for="password" class="pl-2 text-gray-600">
            パスワード
          </label>
          <input
            type="password"
            id="password"
            name="EMPLOYEE_PASSWORD"
            class="input input-info input-bordered w-full"
          />

          <button
            class="
              w-full
              mx-auto
              text-white
              bg-blue-500
              border-0
              py-3
              px-8
              mt-4
              focus:outline-none
              hover:bg-blue-600
              text-lg
              rounded-full
            "
          >
            サインイン
          </button>
        </div>
      </div>
    </form>
  </body>
</html>
