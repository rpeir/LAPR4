/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.ecourse.infrastructure.persistence;

//import eapli.ecourse.boardManagement.repositories.BoardRepository;

import eapli.ecourse.boardManagement.repositories.BoardRepository;
import eapli.ecourse.boardUpdate.repositories.UpdateRepository;
import eapli.ecourse.classmanagment.repositories.ClassRepository;
import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.ecourseusermanagement.repositories.ECourseUserRepository;
import eapli.ecourse.examExecution.repositories.ExamExecutionRepository;
import eapli.ecourse.exammanagment.repositories.ExamRepository;
import eapli.ecourse.postit.repositories.PostItRepository;
import eapli.ecourse.question.repositories.QuestionRepository;
import eapli.ecourse.questionanswer.repositories.QuestionAnswerRepository;
import eapli.ecourse.sharedBoardManagement.repositories.BoardSharedRepository;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * The interface for the repository factory of eCourse.
 */
public interface RepositoryFactory {

	/**
	 * Factory method to create a transactional context to use in the repositories
	 *
	 * @return the transactional context
	 */
	TransactionalContext newTransactionalContext();

	/**
	 *
	 * Creates a new UserRepository with the given transactional context
	 * @param autoTx the transactional context to enroll
	 *
	 * @return the user repository
	 */
	UserRepository users(TransactionalContext autoTx);

	/**
	 * Creates a new UserRepository in auto transaction mode
	 *
	 * @return the user repository
	 */
	UserRepository users();

	/**
	 * Creates a new ECourseUserRepository with the given transactional context
	 * @param autoTx the transactional context to enroll
	 *
	 * @return the eCourse user repository
	 */
	ECourseUserRepository eCourseUsers(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return the eCourse user repository
	 */
	ECourseUserRepository eCourseUsers();

	/**
	 * Creates a new ClassRepository with the given transactional context
	 * @param autoTx the transactional context to enroll
	 *
	 * @return the class repository
	 */
	ClassRepository classes(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return the courses repository
	 */
	ClassRepository classes();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return the courses repository
	 */
	CourseRepository courses();

	/**
	 * Creates a new CourseRepository with the given transactional context
	 *
	 * @param autoTx the transactional context to enroll
	 * @return the courses repository
	 */
	CourseRepository courses(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return the teachers repository
	 */
    TeacherRepository teachers();

	/**
	 * Creates a new TeacherRepository with the given transactional context
	 *
	 * @param autoTx the transactional context to enroll
	 * @return the teachers repository
	 */
	TeacherRepository teachers(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 * @return the course enrollments repository
	 */
    CourseEnrollmentRepository courseEnrollments();

	/**
	 * Creates a new CourseEnrollmentRepository with the given transactional context
	 */
	CourseEnrollmentRepository courseEnrollments(TransactionalContext autoTx);

	/**
	 * Creates a new StudentRepository with the given transactional context
	 * @param autoTx the transactional context to enroll
	 * @return the students repository
	 */
	StudentRepository students(TransactionalContext autoTx);
	/**
	 * repository will be created in auto transaction mode
	 * @return the students repository
	 */
	StudentRepository students();

	/**
	 * Creates a new ExamRepository with the given transactional context
	 */
	ExamRepository exams(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 * @return the exams repository
	 */
	ExamRepository exams();


	/**
	 * repository will be created in auto transaction mode
	 * @return the board repository
	 */
	BoardRepository boards();

	/**
	 * Creates a new BoardRepository with the given transactional context
	 * @param autoTx
	 * @return
	 */
	BoardRepository boards(TransactionalContext autoTx);
	/**
	 * repository will be created in auto transaction mode
	 * @return the boardShared repository
	 */
	BoardSharedRepository boardShared();

	/**
	 * Creates a new BoardSharedRepository with the given transactional context
	 * @param autoTx
	 * @return the boardShared repository
	 */
	BoardSharedRepository boardShared(TransactionalContext autoTx);
	/**
	 * repository will be created in auto transaction mode
	 * @return the question repository
	 */
	QuestionRepository questions();
	/**
	 * Creates a new QuestionRepository with the given transactional context
	 * @return the questionRepository repository
	 */
	QuestionRepository questions(TransactionalContext autoTx);
	/**
	 * Creates a new UpdateRepository with the given transactional context
	 * @return the updateRepository repository
	 */
	UpdateRepository updates(TransactionalContext autoTx);
	/**
	 * repository will be created in auto transaction mode
	 * @return the update repository
	 */
	UpdateRepository updates();
	ExamExecutionRepository examExecutions();
	ExamExecutionRepository examExecutions(TransactionalContext autoTx);
	PostItRepository postIts(TransactionalContext autoTx);
	PostItRepository postIts();

	/**
	 * repository will be created in auto transaction mode
	 * @return the QuestionAnswerRepository
	 */
	QuestionAnswerRepository questionAnswers();
	/**
	 * Creates a new QuestionAnswerRepository with the given transactional context
	 * @return the QuestionAnswerRepository repository
	 */
	QuestionAnswerRepository questionAnswers(TransactionalContext autoTx);


	BoardRepository board();

	BoardRepository board(TransactionalContext autoTx);
}
