<template>
  <div class="layout-padding docs-input row justify-center">
    <div style="width: 500px; max-width: 90vw; text-align: left">
      <q-field>
        <q-input v-model="story.title" float-label="Title" />
      </q-field>
      <q-field>
        <q-input type="textarea" v-model="story.body" float-label="Details" />
      </q-field>
      <q-field>
        <q-input type="text" v-model="story.author.fullName" float-label="Author" />
      </q-field>
      <q-btn color="secondary" icon="save" @click="save()">
        Save
      </q-btn>
    </div>
  </div>
</template>

<script>
import {
  QField,
  QToggle,
  QDatetime,
  QOptionGroup,
  QInput,
  QSelect,
  QChipsInput,
  QRating,
  QBtn,
  QIcon
} from 'quasar'

export default {
  components: {
    QField,
    QToggle,
    QDatetime,
    QOptionGroup,
    QInput,
    QSelect,
    QChipsInput,
    QRating,
    QBtn,
    QIcon
  },

  data () {
    return {
      story: {
        author: {}
      }
    }
  },

  methods: {
    save () {
      console.log(this.story)
      this.$http.post('/stories', this.story)
        .then(resp => {
          this.$router.push({name: 'news_detail', params: {id: resp.data.id}})
        })
    }
  }
}
</script>

<style>
</style>
