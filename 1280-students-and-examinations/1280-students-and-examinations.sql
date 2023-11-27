# Write your MySQL query statement below
# Students(studnet_id, student_name) primary - student_id
# Subjects(subject_name) primary key - subject_name
# Examinations(student_id, subject_name)

# find # of times - student attended each exam
# (student_id, student_name, subject_name, attended_exams)

select s.student_id, s.student_name, sub.subject_name, count(e.subject_name) as attended_exams
FROM Students s
JOIN Subjects sub
LEFT JOIN Examinations e
ON s.student_id = e.student_id AND sub.subject_name = e.subject_name
GROUP BY s.student_id, sub.subject_name
ORDER BY student_id ASC, subject_name ASC
