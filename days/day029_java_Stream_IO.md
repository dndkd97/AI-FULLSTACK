day029

 - Todo1 : java-Stream
 - Todo2 : java-IO

---

### Stream
- 다양한 데이터 소스를 표준화된 방법으로 다루기 위한 기법
- 데이터를 스트림으로 변경하여 데이터종류에 상관 없이 같은 방식으로 처리할 수 있게 자주 사용하는 메서드 정의
- 원본의 데이터가 아닌 별도의 Stream을 생성하여 처리
- 람다식으로 처리할 수 있도록 해주는 반복자
- 여러줄로 쓸 수 있는 것을 한줄로 줄이는 것 가능


구조)
Integer[] arr = { 1, 2, 5, 4, 3, 4, 5, 1, 2, 1, 1, 1, 1, 1, 1 };
List<Integer> list = Arrays.asList(arr);

// 1단계 stream
Stream<Integer> sarr = Arrays.stream(arr);
Stream<Integer> slist = list.stream();

// 2단계 중간연산
//(t)->{}
//void java.util.function.Consumer.accept( T t )
//(t)->{return}
//boolean java.util.function.Predicate.test( T t )

sarr.filter(t->t%2!=0)       // 홀수필터링
.distinct()                  // 중복제거  → 153
.sorted()                    // 정렬     → 135
.limit(2)                    // 갯수 제한 → 13
.skip(1)                     // skip    → 3
.forEach(System.out::print); // 3단계 최종연산

-Comparator.reverseOrder() : 내림차순

### java-I/O

1. Java I/O

- 입력(input)과 출력(output)
- 두 대상간의 데이터를 주고 받는것
- 스트림이란? 사용 연결통로

     입력스트림   →   [프로그램]   →   출력스트림
       InputStream           OutputStream
       Reader                Writer
       
2. Java I/O 분류
- byte(모든종류-그림,멀티미디어,문자) / char(문자)
- byte(InputStream / OutputStream) / char( Reader / Writer)

구조)
//#1. 경로
String folder_rel="src/com/the703/basic016/"; // 상대경로 - 현재작업 폴더기준
String file_path ="io002_byte.txt";
File folder = new File(folder_rel);
File file = new File(folder_rel+file_path);	
//#2. 폴더+파일(exists,mkdirs,createNewFile)
try {
if(!folder.exists()) {folder.mkdir();}
if(!file.exists()) {file.createNewFile();}}catch(Exception e ) {e.printStackTrace();}
System.out.println("폴더/파일완료");
//#3. byte 파일쓰기   InputStream  >   프로그램   >#   OutputStream
try {
    OutputStream output = new FileOutputStream(file);
    output.write('j');
    output.write('a');
    output.write('v');
    output.write('a');
    output.close();
    System.out.println("OutputStream 쓰기 완료");
    } catch (FileNotFoundException e) { e.printStackTrace(); } 
catch (IOException e) { e.printStackTrace(); }


//#4. byte 파일읽기   InputStream  #>   프로그램   >   OutputStream

try {
    InputStream input = new FileInputStream(file) ;
    int cnt = 0;
    while((cnt = input.read())!=-1) { // -1 끝
        System.out.print(((char)cnt));
    }
    input.close();
} catch (FileNotFoundException e) {  e.printStackTrace(); } 
    catch (IOException e) { e.printStackTrace(); }