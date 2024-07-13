<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        height: 100vh;
        margin: 0;
        background-color: #2c3e50;
        color: white;
        font-family: Arial, sans-serif;
    }

    #confetti-container {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        pointer-events: none;
        overflow: hidden;
    }

    .confetti {
        position: absolute;
        width: 10px;
        height: 10px;
        background-color: #f39c12;
        opacity: 0;
        animation: confetti-fall 3s linear infinite;
    }

    @keyframes confetti-fall {
        0% {
            opacity: 1;
            transform: translateY(0) rotate(0);
        }
        100% {
            opacity: 0;
            transform: translateY(100vh) rotate(360deg);
        }
    }

    #message-container {
        margin-top: 20px;
        text-align: center;
    }
</style>
<body>
    <div id="confetti-container"></div>
    <div id="message-container"></div>

    <script>
        window.onload = function() {
            for (let i = 0; i < 100; i++) {
                createConfetti();
            }
            showConfirmationMessage();
        };

        function createConfetti() {
            const confetti = document.createElement('div');
            confetti.classList.add('confetti');

            confetti.style.backgroundColor = getRandomColor();
            confetti.style.left = Math.random() * 100 + 'vw';
            confetti.style.animationDelay = Math.random() * 2 + 's';

            document.getElementById('confetti-container').appendChild(confetti);

            setTimeout(() => {
                confetti.remove();
            }, 3000);
        }

        function getRandomColor() {
            const colors = ['#f39c12', '#e74c3c', '#8e44ad', '#3498db', '#1abc9c', '#2ecc71'];
            return colors[Math.floor(Math.random() * colors.length)];
        }

        function showConfirmationMessage() {
            const messageContainer = document.getElementById('message-container');
            messageContainer.innerHTML = `
                <h2>Thank you for your order!</h2>
                <p>Your food will be delivered shortly.</p>
            `;
        }
    </script>
</body>
</html>
