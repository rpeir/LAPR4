/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.ecourse.persistence.impl.inmemory;

//import eapli.ecourse.boardManagement.repositories.BoardRepository;

import eapli.ecourse.boardManagement.repositories.BoardRepository;
import eapli.ecourse.boardUpdate.repositories.UpdateRepository;
import eapli.ecourse.classmanagment.repositories.ClassRepository;
import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.ecourseusermanagement.repositories.ECourseUserRepository;
import eapli.ecourse.examExecution.repositories.ExamExecutionRepository;
import eapli.ecourse.exammanagment.repositories.ExamRepository;
import eapli.ecourse.infrastructure.bootstrapers.ECourseBootstrapper;
import eapli.ecourse.infrastructure.persistence.RepositoryFactory;
import eapli.ecourse.persistence.impl.jpa.JpaPostItRepository;
import eapli.ecourse.postit.repositories.PostItRepository;
import eapli.ecourse.question.repositories.QuestionRepository;
import eapli.ecourse.questionanswer.repositories.QuestionAnswerRepository;
import eapli.ecourse.sharedBoardManagement.repositories.BoardSharedRepository;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.inmemory.InMemoryUserRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryTransactionalContext;

/**
 * The repository factory for in-memory repositories.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

	/**
	 * Creates a new InMemory transactional context.
	 *
	 * @return the transactional context
	 */
	@Override
	public TransactionalContext newTransactionalContext() {
		return new InMemoryTransactionalContext();
	}

	@Override
	public UserRepository users(TransactionalContext autoTx) {
		final InMemoryUserRepository repo = new InMemoryUserRepository();
		ECourseBootstrapper.registerAdmin(repo);
		return repo;
	}

	@Override
	public UserRepository users() {
		return users(null);
	}

	@Override
	public ECourseUserRepository eCourseUsers(TransactionalContext autoTx) {
		return new InMemoryECourseUserRepository();
	}

	@Override
	public ECourseUserRepository eCourseUsers() {
		return new InMemoryECourseUserRepository();
	}

	@Override
	public ClassRepository classes(TransactionalContext autoTx) {
		return new InMemoryClassRepository();
	}

	@Override
	public ClassRepository classes() {
		return new InMemoryClassRepository();
	}

	@Override
	public CourseRepository courses() {
		return courses(null);
	}

	@Override
	public CourseRepository courses(TransactionalContext autoTx) {
		return new InMemoryCourseRepository();
	}

	@Override
	public TeacherRepository teachers(){
		return teachers(null);
	}

	@Override
	public TeacherRepository teachers(TransactionalContext autoTx){
		return new InMemoryTeacherRepository();
	}

	@Override
	public CourseEnrollmentRepository courseEnrollments() {
		return courseEnrollments(null);
	}

	@Override
	public CourseEnrollmentRepository courseEnrollments(TransactionalContext autoTx) {
		return new InMemoryCourseEnrollmentRepository();
	}

	/**
	 * @return
	 */
	@Override
	public QuestionRepository questions() {
		return questions(null);
	}

	/**
	 * @param autoTx
	 * @return
	 */
	@Override
	public QuestionRepository questions(TransactionalContext autoTx) {
		return new InMemoryQuestionRepository();
	}

	@Override
	public UpdateRepository updates(TransactionalContext autoTx) {
		return new InMemoryUpdateRepository();
	}

	@Override
	public UpdateRepository updates() {
		return new InMemoryUpdateRepository();
	}

	@Override
	public ExamExecutionRepository examExecutions() {
		return new InMemoryExamExecutionRepository();
	}

	@Override
	public ExamExecutionRepository examExecutions(TransactionalContext autoTx) {
		return new InMemoryExamExecutionRepository();
	}

	@Override
	public PostItRepository postIts(TransactionalContext autoTx) {
		return new InMemoryPostItRepository();
	}

	@Override
	public PostItRepository postIts() {
		return new InMemoryPostItRepository();
	}

	@Override
	public QuestionAnswerRepository questionAnswers() {
		return new InMemoryQuestionAnswerRepository();
	}

	@Override
	public QuestionAnswerRepository questionAnswers(TransactionalContext autoTx) {
		return new InMemoryQuestionAnswerRepository();
	}

	/**
	 * @return
	 */
	@Override
	public BoardRepository board() {
		return null;
	}

	/**
	 * @param autoTx
	 * @return
	 */
	@Override
	public BoardRepository board(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public StudentRepository students(TransactionalContext autoTx) {
		return new InMemoryStudentRepository();
	}

	@Override
	public StudentRepository students() {
		return new InMemoryStudentRepository();
	}

	@Override
	public ExamRepository exams(TransactionalContext autoTx) {
		return new InMemoryExamRepository();
	}

	@Override
	public ExamRepository exams() {
		return new InMemoryExamRepository();
	}

	@Override
	public BoardRepository boards() {
		return new InMemoryBoardRepository();
	}

	@Override
	public BoardRepository boards(TransactionalContext autoTx) {
		return new InMemoryBoardRepository();
	}

	@Override
	public BoardSharedRepository boardShared() {
		return new InMemorySharedBoardRepository();
	}

	@Override
	public BoardSharedRepository boardShared(TransactionalContext autoTx) {
		return new InMemorySharedBoardRepository();
	}

}
