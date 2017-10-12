<template>
  <!-- Configure "view" prop for QLayout -->
    <div class="layout-padding card-examples row items-start" style="width: 40%; text-align: left">
      <div v-for="story in stories">
        <q-card inline color="secondary">
          <q-card-title>
            {{story.title}}
            <span slot="subtitle">{{story.author.fullName}} - {{story.publishedDate}}</span>
          </q-card-title>
          <q-card-main>
            {{story.body}}
          </q-card-main>
          <q-card-separator />
          <q-card-actions>
            <q-btn flat @click="getStory( story.id )">HTML</q-btn>
            <q-btn flat @click="getStoryJson( story.id )">JSON</q-btn>
            <q-btn flat @click="getStoryXml( story.id )">XML</q-btn>
          </q-card-actions>
        </q-card>
      </div>
    </div>
    <!-- Footer
    <q-toolbar slot="footer">
      ...
    </q-toolbar>
    -->
</template>

<script>
import {
  QCard,
  QCardTitle,
  QCardMain,
  QCardSeparator,
  QCardActions,
  QBtn
} from 'quasar'
export default {
  components: {
    QCard,
    QCardTitle,
    QCardMain,
    QCardSeparator,
    QCardActions,
    QBtn
  },
  data () {
    return {
      stories: []
    }
  },

  created () {
    this.fetchStories()
  },

  methods: {
    fetchStories () {
      this.$http.get('/stories?sort=publishedDate,desc')
        .then(resp => {
          this.stories = resp.data.content
        })
    },

    getStory (storyId) {
      this.$router.push({name: 'news_detail', params: {id: storyId}})
    },

    getStoryJson (storyId) {
      this.$router.push({name: 'news_detail_json', params: {id: storyId}})
    },

    getStoryXml (storyId) {
      this.$router.push({name: 'news_detail_xml', params: {id: storyId}})
    }
  }
}
</script>

<style>
</style>
