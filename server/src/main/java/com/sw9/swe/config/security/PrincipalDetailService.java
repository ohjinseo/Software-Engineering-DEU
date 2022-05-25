package com.sw9.swe.config.security;

import com.sw9.swe.domain.student.Student;
import com.sw9.swe.exception.StudentNotFoundException;
import com.sw9.swe.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    private final StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("RegistrationNumber : " + username);
        Student student = studentRepository.findByRegistrationNumber(Long.valueOf(username)).orElseThrow(StudentNotFoundException::new);
        return new PrincipalDetails(student);
    }
}
