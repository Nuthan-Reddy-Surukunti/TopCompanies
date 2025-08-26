package com.example.topcompanies

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

 data class TopCompany(val name: String, val description: String, val imageResId: Int)

class TopCompanyAdapter(private val context: Context, private val items: List<TopCompany>) : BaseAdapter() {
    override fun getCount(): Int = items.size
    override fun getItem(position: Int): Any = items[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_top_company, parent, false)
        val item = items[position]
        val imageView = view.findViewById<ImageView>(R.id.image_top_company)
        val nameView = view.findViewById<TextView>(R.id.text_top_company_name)
        val descView = view.findViewById<TextView>(R.id.text_top_company_desc)
        imageView.setImageResource(item.imageResId)
        nameView.text = item.name
        descView.text = item.description
        return view
    }
}

class CompanyListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_list)

        val companyType = intent.getStringExtra("company_type") ?: "Unknown"

        supportActionBar?.title = companyType

        val companies = when (companyType) {
            "Android companies" -> getAndroidCompanies()
            "iOS companies" -> getIOSCompanies()
            "React companies" -> getReactCompanies()
            "Full Stack companies" -> getFullStackCompanies()
            else -> getDemoCompanies()
        }

        val listView = findViewById<ListView>(R.id.list_top_companies)
        listView.adapter = TopCompanyAdapter(this, companies)
    }

    private fun getAndroidCompanies(): List<TopCompany> {
        return listOf(
            TopCompany(
                name = "Mindinventory (Ahmedabad)",
                description = "Experts in Android and cross-platform development (Flutter, React Native), known for combining exceptional design with development—a solid pick for founders seeking both disciplines under one roof.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Konstant Infosolutions (Jaipur)",
                description = "A full-stack mobile development powerhouse serving startups and enterprises. Recognized for design, development, QA, and proficiency in Kotlin, Android SDK, IoT, AI/ML, and AR/VR.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "TechAhead (Noida)",
                description = "Strong in Android, enterprise mobility, and IoT. Offers full-cycle digital product engineering with a solid U.S. presence—ideal for brands needing mobile + device integration.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Hyperlink InfoSystem (Ahmedabad)",
                description = "Renowned for fast turnaround and bulk hiring. Delivers native Android (Java, Kotlin) and cross-platform apps at scale—great for large projects with tight deadlines.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Appinventiv (Noida)",
                description = "Global client base, full mobile lifecycle support—from strategy and design to development. Excellent for startups and enterprises requiring structured support.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "OpenXcell (Ahmedabad)",
                description = "Full-stack expertise in Android with backend integrations, cloud, AI/ML capabilities. Strong enterprise-app specialization.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Daffodil Software (Gurgaon)",
                description = "Specializes in Android apps for healthcare and fintech. Known for delivering industry-specific, regulated compliance solutions.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Quytech (Gurgaon)",
                description = "Focused on Android apps enriched with AR/VR and emerging technologies—excellent fit for startups aiming for immersive experiences.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Innov8World (Various)",
                description = "A growing name emphasizing native Android development (Java, Kotlin), UI/UX, backend/API integration, QA/testing, and end-to-end services across startups and enterprises.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Algoworks (Multiple Zones)",
                description = "An enterprise-grade firm delivering Android and cross-platform apps, with a strong focus on maintenance, cloud migration, and scalability.",
                imageResId = R.drawable.ic_launcher_foreground
            )
        )
    }

    private fun getIOSCompanies(): List<TopCompany> {
        return listOf(
            TopCompany(
                name = "Singsys (Lucknow & Singapore)",
                description = "Established IT firm with ~15 years in the mobile/web development space. Known for crafting scalable, user-friendly iOS apps, UI/UX design, and enterprise mobility solutions.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Hidden Brains (Ahmedabad)",
                description = "With over two decades of experience and 5,000+ projects delivered across 100+ countries, this award-winning company integrates cutting-edge tech like AI, IoT, and cloud into its iOS apps.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Techugo (Noida)",
                description = "A CMMI Level 3 company collaborating with startups, Fortune 500s, and government entities. Notable for highly impactful solutions—such as a Guinness World Record app—and involvement in high-profile projects like Byju's.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Hyperlink InfoSystem (Mumbai)",
                description = "A prolific player with 4,000+ mobile apps and 2,000+ websites to its credit. Offers a wide range of services—from iOS to Blockchain and AR/VR development—via a structured and quality-centric process.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "OpenXcell (Ahmedabad)",
                description = "A CMMI Level 3–certified company trusted by global clients. Known for delivering secure, scalable, enterprise-grade iOS applications across sectors like healthcare, finance, and logistics.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Konstant Infosolutions (Jaipur)",
                description = "A well-established firm with 20+ years in mobile app development. Specializes in iOS/iPad solutions with features like AR/VR, AI/ML, HealthKit, HomeKit, and Apple Watch integration.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Appinventiv (Noida)",
                description = "A powerhouse delivering over 1,500 apps across fintech, healthcare, and more. Focuses on agile, enterprise-grade iOS solutions with strong UI/UX and innovation-driven engineering.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "ValueCoders (India-wide)",
                description = "A trusted name with about 20 years of experience, over 4,200 projects delivered, and ISO-certified processes. Offers cost-effective, secure, and feature-rich iOS app development.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Algoworks (India + US, Canada)",
                description = "A strategic partner for startups and enterprises alike. Delivers intuitive, visually compelling iOS apps with integration into Apple's ecosystem (iPadOS, watchOS, tvOS). Known for technical maturity including Core ML and WidgetKit.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Damco Solutions (India + USA, UK)",
                description = "Founded in 1996, Damco offers end-to-end iOS services—from consulting to launch—with expertise in Swift, SwiftUI, and Xcode, delivering scalable, production-quality apps.",
                imageResId = R.drawable.ic_launcher_foreground
            )
        )
    }

    private fun getReactCompanies(): List<TopCompany> {
        return listOf(
            TopCompany(
                name = "Orbit Edge Tech",
                description = "Known for high-quality, scalable, performance-driven React apps—including SPAs and mobile solutions. Reliable and cost-effective for startups and enterprises alike.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "MindInventory",
                description = "A full-cycle digital solutions provider with deep React.js expertise. Excels in building SPAs and enterprise-grade applications using UI-first approaches.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Bacancy Technology",
                description = "Offers end-to-end React solutions, including PWAs and real-time apps. Agile workflow, large global team, AI/ML integration, and multi-domain experience.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "PixelCrayons",
                description = "A trusted name for React front-end development in e-commerce, healthcare, and finance sectors. Emphasizes speed-to-market and solid performance.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Konstant Infosolutions",
                description = "Full-stack development powerhouse with strong React.js capabilities. Known for responsive, feature-rich applications tailored to modern business needs.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Brainvire Infotech",
                description = "A global IT consulting leader offering sophisticated React.js solutions for retail, healthcare, education, and digital transformation projects.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "CronJ IT Technologies",
                description = "Focuses on performant, scalable React.js applications with strong UI/UX design and reusable architecture. Works across logistics, finance, and healthcare.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "GeekyAnts",
                description = "Developer-driven and known for front-end innovation. Prolific in React.js, React Native, SPAs, PWAs, and design systems for both startups and Fortune 500s.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "TatvaSoft",
                description = "Enterprise-grade React.js provider delivering scalable, secure architectures across finance, travel, education, and other domains.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Clarion Technologies",
                description = "Extensive track record—500+ React.js projects for 1,500+ businesses. Strong focus on interactive UIs, state management, and cross-platform reliability.",
                imageResId = R.drawable.ic_launcher_foreground
            )
        )
    }

    private fun getFullStackCompanies(): List<TopCompany> {
        return listOf(
            TopCompany(
                name = "eSparkBiz (Ahmedabad)",
                description = "With 14+ years of experience, eSparkBiz excels in full-stack, SaaS, and cloud solutions. Recognized for exceptional staff augmentation services, they've completed over 1,000 projects.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "PixelCrayons",
                description = "With more than two decades in the industry, PixelCrayons delivers scalable full-stack software across domains like AI/ML, blockchain, and MVC frameworks. Known for tackling complex builds with optimized UIs.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "ValueCoders",
                description = "A seasoned player with 20 years of experience, ValueCoders brings ISO-certified processes and strong digital transformation capabilities to the table.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "CONTUS Tech (Chennai)",
                description = "Serving verticals like Banking, Automotive, Healthcare, and Telecom, CONTUS offers full-stack, SaaS, OTT, and DevOps development with over 300 seasoned developers.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Colan Infotech (Chennai)",
                description = "A decade-old firm offering full-stack solutions—ranging from Angular/React/Node.js to Python and PHP. They work across web, blockchain, mobile dev, and digital marketing.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Apptha (Chennai)",
                description = "Focused on full-stack, SaaS, and cloud-native solutions, Apptha is strong in microservices, Kubernetes, and headless commerce—tailored especially for e-commerce and SaaS businesses.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "AffoWeb (Bangalore)",
                description = "Experts in MERN/MEAN stacks and cloud-native apps, AffoWeb brings API-first development for e-commerce, SaaS, and healthcare, all at competitive pricing and rapid delivery.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Vocso Technologies (Gurgaon)",
                description = "Affordable yet high-quality, particularly for Node.js/React-based full-stack projects. Known for scalable architectures and WordPress plugin innovations.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Aalpha Info Systems",
                description = "Ranked among the top full-stack firms in 2025, Aalpha specializes in web, mobile, SaaS, AI/ML, and UI/UX—offering full-cycle development at rates of $25–$49/hr.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            TopCompany(
                name = "Quytech",
                description = "A technology-forward firm leveraging AI, ML, IoT, AR/VR. Quytech delivers end-to-end full-stack solutions—from ideation to maintenance—for global clients like HP, Honda, and Marks & Spencer.",
                imageResId = R.drawable.ic_launcher_foreground
            )
        )
    }

    private fun getDemoCompanies(): List<TopCompany> {
        return List(10) { i ->
            TopCompany(
                name = "Demo Company ${i+1}",
                description = "This is a description for Demo Company ${i+1}.",
                imageResId = R.drawable.ic_launcher_foreground
            )
        }
    }
}
