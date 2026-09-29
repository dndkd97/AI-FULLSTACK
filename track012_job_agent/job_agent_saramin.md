### 1단계: 개발 환경 구성 (Python 및 Playwright 설치)

> 컴퓨터의 터미널(명령 프롬프트)을 열고 자동화에 필요한 파이썬 라이브러리를 설치합니다.

```bash
pip install playwright
playwright install chromium

```

1) playwright - 웹크롤링, 웹브라우저 제어
2) chromium - 동적 웹크롤링

※ 작동확인 
```
npx  playwright open  http://naver.com
```

### 2단계 : 자동 로그인 세션(쿠키)만들기
> sava_login.py
```
import os
from playwright.sync_api import sync_playwright

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
STATE_PATH = os.path.join(BASE_DIR, "state.json")

with sync_playwright() as p:
    # 1. 일반 크롬 브라우저 실행
    browser = p.chromium.launch(
        channel="chrome",
        headless=False,
        args=["--disable-blink-features=AutomationControlled", "--start-maximized"]
    )
    context = browser.new_context(no_viewport=True)
    page = context.new_page()

    page.goto("https://www.saramin.co.kr/zf_user/auth")

    print("\n==================================================")
    print("1. 브라우저에서 사람인 로그인(소셜 로그인 포함)을 완료하세요.")
    print("2. 로그인 완료 후 사람인 메인 화면이 정상적으로 나오면 Enter를 누르세요.")
    print("==================================================\n")
    input("로그인 완료 후 Enter를 누르세요: ")

    # 2. 쿠키 + LocalStorage 등 세션 전체를 state.json 파일로 공식 저장
    context.storage_state(path=STATE_PATH)
    print(f"✅ 로그인 세션이 성공적으로 저장되었습니다: {STATE_PATH}")
    
    browser.close()
```

1. 실행하고
2. 로그인한다음
3. 메인페이지로이동
4. 콘솔창으로 와서 enter
5. 로그인 정보 기록이 state.json에 남음

### 3.