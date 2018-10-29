import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.*
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource


/**
 * @author devagoud
 */

@Configuration
@EnableTransactionManagement
 class DataBaseConfiguration

    @Value("\${spring.datasource.url}")
  lateinit var url:String
    @Value("\${spring.datasource.password}")
   lateinit var password:String
    @Value("\${spring.datasource.username}")
   lateinit var  username:String

    @Bean
    fun entityManagerFactory():LocalContainerEntityManagerFactoryBean{
        var em=LocalContainerEntityManagerFactoryBean()
        em.setDataSource(dataSource());
        //em.setPackagesToScan( String[] {"com.kotlin.demo.deomapplications.config })
            var vendorAdapter = HibernateJpaVendorAdapter()
            em.setJpaVendorAdapter(vendorAdapter)
            em.setJpaProperties(additionalProperties())
            return em;
        }

       @Bean
      fun dataSource():DataSource{
        var dataSource = DriverManagerDataSource()
        dataSource.setUrl(url)
        dataSource.setUsername(username)
        dataSource.setPassword(password)
        return dataSource
        }

    @Bean
    fun transactionManager(emf:EntityManagerFactory):PlatformTransactionManager{
       var  transactionManager = JpaTransactionManager()
        transactionManager.setEntityManagerFactory(emf)

        return transactionManager
    }

    @Bean
    fun exceptionTranslation(): PersistenceExceptionTranslationPostProcessor{
        return PersistenceExceptionTranslationPostProcessor()
    }

    fun additionalProperties():Properties {
        var properties = Properties()
        properties.setProperty("hibernate.hbm2ddl.auto", "update")
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")

        return properties
    }