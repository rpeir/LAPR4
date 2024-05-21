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
package eapli.ecourse.persistence.impl.jpa;

import eapli.ecourse.Application;
import eapli.ecourse.boardManagement.repositories.BoardRepository;
import eapli.ecourse.boardUpdate.repositories.UpdateRepository;
import eapli.ecourse.classmanagment.repositories.ClassRepository;
import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.ecourseusermanagement.repositories.ECourseUserRepository;
import eapli.ecourse.examExecution.repositories.ExamExecutionRepository;
import eapli.ecourse.exammanagment.repositories.ExamRepository;
import eapli.ecourse.infrastructure.persistence.RepositoryFactory;
import eapli.ecourse.postit.repositories.PostItRepository;
import eapli.ecourse.question.repositories.QuestionRepository;
import eapli.ecourse.questionanswer.repositories.QuestionAnswerRepository;
import eapli.ecourse.sharedBoardManagement.repositories.BoardSharedRepository;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.jpa.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 * The repository factory for JPA repositories.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

	/**
	 * Creates a new JPA transactional context.
	 *
	 * @return the transactional context
	 */
	@Override
	public TransactionalContext newTransactionalContext() {
		return JpaAutoTxRepository.buildTransactionalContext(Application.settings().persistenceUnitName(),
				Application.settings().extendedPersistenceProperties());
	}

	@Override
	public UserRepository users(final TransactionalContext autoTx) {
		return new JpaAutoTxUserRepository(autoTx);
	}

	@Override
	public UserRepository users() {
		return new JpaAutoTxUserRepository(Application.settings().persistenceUnitName(),
				Application.settings().extendedPersistenceProperties());
	}

	@Override
	public ECourseUserRepository eCourseUsers(TransactionalContext autoTx) {
		return new JpaECourseUserRepository(autoTx);
	}

	@Override
	public ECourseUserRepository eCourseUsers() {
		return new JpaECourseUserRepository(Application.settings().persistenceUnitName(),
				Application.settings().extendedPersistenceProperties());
	}

	@Override
	public ClassRepository classes(TransactionalContext autoTx) {
		return new JpaClassRepository(autoTx);
	}

	@Override
	public ClassRepository classes() {
		return new JpaClassRepository(Application.settings().persistenceUnitName());
	}

	@Override
	public CourseRepository courses() {
		return new JpaCourseRepository(Application.settings().persistenceUnitName());
	}

	@Override
	public CourseRepository courses(final TransactionalContext autoTx){
		return new JpaCourseRepository(autoTx);
	}

	@Override
	public TeacherRepository teachers() {
		return new JpaTeacherRepository(Application.settings().persistenceUnitName());
	}

	@Override
	public TeacherRepository teachers(final TransactionalContext autoTx){
		return new JpaTeacherRepository(autoTx);
	}

	@Override
	public CourseEnrollmentRepository courseEnrollments() {
		return new JpaCourseEnrollmentRepository(Application.settings().persistenceUnitName());
	}

	@Override
	public CourseEnrollmentRepository courseEnrollments(TransactionalContext autoTx) {
		return new JpaCourseEnrollmentRepository(autoTx);
	}

	@Override
	public StudentRepository students(TransactionalContext autoTx) {
		return new JpaStudentRepository(autoTx);
	}

	@Override
	public StudentRepository students() {
		return new JpaStudentRepository(Application.settings().persistenceUnitName());
	}

	@Override
	public ExamRepository exams(TransactionalContext autoTx) {
		return new JpaExamRepository(autoTx);
	}

	@Override
	public ExamRepository exams() {
		return new JpaExamRepository(Application.settings().persistenceUnitName());
	}


	@Override
	public BoardRepository boards() {
		return new JpaBoardRepository(Application.settings().persistenceUnitName());
	}

	@Override
	public BoardRepository boards(TransactionalContext autoTx) {
		return new JpaBoardRepository(autoTx);
	}

	@Override
	public BoardSharedRepository boardShared() {
		return new JpaBoardSharedRepository(Application.settings().persistenceUnitName());
	}

	@Override
	public BoardSharedRepository boardShared(TransactionalContext autoTx) {
		return new JpaBoardSharedRepository(autoTx);
	}


	/**
	 * @return
	 */
	@Override
	public QuestionRepository questions() {
		return new JpaQuestionRepository(Application.settings().persistenceUnitName());
	}

	/**
	 * @param autoTx
	 * @return
	 */
	@Override
	public QuestionRepository questions(TransactionalContext autoTx) {
		return new JpaQuestionRepository(autoTx);
	}

	@Override
	public UpdateRepository updates(TransactionalContext autoTx) {
		return new JpaUpdateRepository(autoTx);
	}

	@Override
	public UpdateRepository updates() {
		return new JpaUpdateRepository(Application.settings().persistenceUnitName());
	}
	@Override
	public ExamExecutionRepository examExecutions(){
		return new JpaExamExecutionRepository(Application.settings().persistenceUnitName());
	}
	@Override
	public ExamExecutionRepository examExecutions(TransactionalContext autoTx){
		return new JpaExamExecutionRepository(autoTx);
	}
	@Override
	public PostItRepository postIts(){
		return new JpaPostItRepository(Application.settings().persistenceUnitName());
	}

	@Override
	public QuestionAnswerRepository questionAnswers() {
		return new JpaQuestionAnswerRepository(Application.settings().persistenceUnitName());
	}

	@Override
	public QuestionAnswerRepository questionAnswers(TransactionalContext autoTx) {
		return new JpaQuestionAnswerRepository(autoTx);
	}

	/**
	 * @return
	 */
	@Override
	public BoardRepository board() {
		return new JpaBoardRepository(Application.settings().persistenceUnitName());
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
	public PostItRepository postIts(TransactionalContext autoTx){
		return new JpaPostItRepository(autoTx);
	}
}
