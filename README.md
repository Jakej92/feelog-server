# Feelog

<h1>Collaborative Emotion Diary - 'Feelog'</h1>

<h2>1. Project Purpose</h2>

<img src="https://github.com/user-attachments/assets/0560e041-2cc7-44d7-ba6d-848b4ea0b412"/>

Although depression and suicide rates are declining globally, Korea still shows <strong>high rates of suicide and depression prevalence</strong>.</br>
This project was planned to move beyond the traditional style of simple diary records and create a <strong>platform to share and communicate emotions</strong> to lighten the emotional burden.

<h2>2. Expected Outcomes</h2>

<img src="https://github.com/user-attachments/assets/7216d8d2-99a1-4cbd-a2e8-6c8cbd878cab"/>

Encourages the formation of <strong>emotional management habits and emotional recovery</strong>.</br>
Also provides a sense of <strong>emotional stability</strong> through community-based empathy and support.</br>
Promotes participation in healing challenges in everyday life and offers <strong>emotional release and positive experiences</strong> through support messages and emoticons.

<h2>3. Tools Used in the Project</h2>

💻 Language & Frameworks
- Java
- Javascript
- Spring Boot
- Fast API
- MyBatis
- JSON
- Thymeleaf
- Python

🛠️ Development Environment & IDEs
- IntelliJ IDEA
- Pycharm
- Visual Studio Code
- Sourcetree
- Git, Github
- Apache Tomcat
- JDK 11.0.15

🗄️ Databases & DB Tools
- Oracle Database
- MySql

🌐 APIs & External Services
- Kakao Developers (Login API)
- CoolSMS API
- OpenAI Platform

📦 Build & Dependency Management
- Gradle

🔔 Collaboration & Communication
- Slack

🎨 Design & Publishing
- HTML / CSS

📷 Other Tools
- Thumbnailator
- Lombok

🧪 Testing & Debugging
- Postman

<h2>4. ERD</h2>

<img src="https://github.com/user-attachments/assets/2357e86f-5406-49a5-ac8e-4dea61ea3208"/>

<h2>5. Responsibilities</h2>
5-1 Publishing

<img src="https://github.com/user-attachments/assets/229c922f-606c-4bad-8ef1-4074199228ee"/>

▶ Official Channel
- Official channel homepage (Notices, Challenges)
- Notice list

▶ Main Page
- Header, Footer
- Main Page
- Emotion diary creation/editing/AI view
- Post, support message creation/editing/preview view
- Search modal, integrated search result view
- FAQ list/detail
- 1:1 Inquiry (Email)

▶ Personal Page
- Create new channel
- Personal channel main (Emotion Diary, Posts, Support Messages)
- Emotion Diary List
- Post List
- Support Message List

▶ About Site / 404 Error Page
- About Page
- 404 Error Page

5-2 Server

<img src="https://github.com/user-attachments/assets/a44b1be7-e117-4696-990b-d42c776841c7"/>
<img src="https://github.com/user-attachments/assets/778d1d2a-5dfa-492d-8fdf-8d4b688a11c3"/>

▶ Official Channel
- Home screen and basic info display
- Notice list with pagination
- Display challenge list
- Channel subscription/unsubscription feature

▶ Main Page
- Write Features
    - Provide buttons to write Emotion Diary / General Post / Support Message
    - Use JQuery SummerNote editor for each form (supports fonts/image upload)
    - Representative image upload
    - Tag input based on user input (prevents duplicates, renders chips in real time)
- Emotion Diary
    - AI-based emotion score evaluation after submission
    - Display emoticon/message based on score
    - Allow users to manually select emotion score
    - Visibility options: Public / Subscribers only / Private
    - Nickname visibility options: Show / Anonymous
    - Re-display AI analysis on edit
- General Post / Support Message
    - Set post type: General / Support
    - Preview after creation
    - Include tags and thumbnail
    - Support edit
- Notification
    - Notification dropdown when header button clicked
    - Subscriber notifications
    - Received messages
    - Post/support comments/likes
    - Community post/like
    - Mark as read / update count
- Search
    - Search modal opens when clicking header icon
    - On keyword input, show results by:
        - Emotion Diary
        - General Post
        - Support Message
        - Channel
    - Load 5 items initially, “More” loads more
    - Subscribe/Unsubscribe for channels
    - Result items include:
        - Thumbnail
        - Title
        - Snippet of content
        - Author nickname
        - Tag info
    - Auto-suggest related keywords and popular tags
    - Search triggered via Enter or button

▶ Support
- FAQ list page
- FAQ detail page
- 1:1 inquiry via email

▶ Personal Channel
- Home screen composition
- Tabs for Emotion Diary / Free Posts / Support Messages
- Pagination + subscriber-only restriction

<h2>6. Troubleshooting</h2>

<h3>1. Problem</h3> 
💡 Duplicate saving of Summernote image files in DB

<h3>2. Solution</h3>
✏️ Refactored based on features, not HTML. Divided JS files per feature for easier maintenance and to avoid duplication.

<h2>7. Reflections</h2>

<h3>🌱 Confidence Built Through Familiarity </h3>
I felt that I had grown compared to my previous projects. Compared to before, I was able to work at a faster pace, and many of the codes and patterns were things I had seen in past projects as well as during this one, so I could proceed without hesitation. Even when something new came up, I was able to understand how it worked much faster than before, making it easier to use unfamiliar code. Although learning something new is always challenging at first, once I actually tried using it, it became more enjoyable.

<h3>🧭 Thorough Planning Determines the Outcome</h3>
I was once again reminded that poor planning inevitably leads to consequences during the coding phase. Parts I had glossed over in the planning stage with a “this should be fine” mindset ended up becoming far bigger obstacles during implementation than I had expected. A small gap in planning changed the entire flow and forced me to roll back code multiple times. For the next project, I’m determined to create more detailed planning documents and include practical-level flowcharts and clear state definitions from the start.

<h3>🚧 Deployment marks the beginning, not the end.</h3>
Features that worked flawlessly during development caused unexpected issues in the production environment. Things that seemed minor—like session handling, cookie behavior, or image paths—turned out to be critical errors from the user's perspective. I realized that for a developer, deployment isn't just about pushing code to a server—it's the starting point of real user interaction. Moving forward, I will make it a habit to anticipate a wider range of scenarios during the testing phase and always evaluate from the end-user’s point of view.

<h3>🔍 Small Mistakes Can Consume a Lot of Debugging Time</h3>
I spent much more time tracking down small errors than actually writing code. Simple things like typos, missing conditions, or minor query mistakes often disrupted the entire flow. Through repeated experiences like this, I realized how important it is to be careful with every single line of code. While the phrase “let’s get it right from the start” is common, I truly felt that it takes real discipline and focus to actually follow through on it.

<h3>📘 Documentation Is a Developer’s Weapon</h3>
Even just a few days after writing my own code, I found it difficult to understand the flow again. In areas with complex logic or heavily conditional queries, a single line of comments made a huge difference. During this project, I had documented the use of an interceptor that the instructor taught us early on—but as development got busy, I forgot to apply it in the actual flow. It wasn’t until a review session with the instructor that the omission was pointed out, and only then did I realize what I had missed and go back to fix it.

This experience taught me a hard lesson: documentation without follow-through is meaningless. It’s not enough to simply write things down—important parts must be regularly checked and integrated into the code. From now on, I’ll make it a habit not only to maintain comments, technical notes, and specifications, but also to turn that documentation into action. I aim to become a developer who treats documentation as a natural part of development.

